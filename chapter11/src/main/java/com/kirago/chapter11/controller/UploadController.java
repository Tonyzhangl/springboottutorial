package com.kirago.chapter11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    private void executeUpload(String uploadDir, MultipartFile multipartFile) throws Exception{
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID() + suffix;
        File file = new File(uploadDir + filename);
        multipartFile.transferTo(file);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request, MultipartFile file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir,file);
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public  @ResponseBody
    String uploads(HttpServletRequest httpServletRequest, MultipartFile[] multipartFiles) {
        try {
            String uploadPath = httpServletRequest.getSession().getServletContext().getRealPath("/")+"/upload";
            File file = new File(uploadPath);
            if(!file.exists()){
                file.mkdir();
            }
            for(int i = 0;i<multipartFiles.length;i++){
                if(multipartFiles[i] !=null){
                    executeUpload(uploadPath, multipartFiles[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败！";
        }
        return "上传成功!";
    }

}
