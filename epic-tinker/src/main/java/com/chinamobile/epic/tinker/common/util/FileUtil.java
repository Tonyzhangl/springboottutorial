package com.chinamobile.epic.tinker.common.util;

import com.chinamobile.epic.tinker.common.constants.ResponseConstant;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangjunsheng
 * @Date: 2019/11/4
 * @Descrption:
 */
public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
    public static String uploadFile(String sufPath, MultipartFile file){
        Map<String, Object> resultMap = new HashMap<>();
        //判断文件是否为空
        String path = ResponseConstant.PRE_PATH + "/" + sufPath;
        if(!file.isEmpty()) {
            //判断文件目录是否存在，否则自动生成(这里文件上传的路径组成部分为系统Id)
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            try {
                //将文件保存到指点目录；
                File newFile = new File(path +"/"+ file.getOriginalFilename());
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("服务器异常！");
                return null;
            }
        }else{
            log.error("上传文件为空！");
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.FAIL, "上传文件为空", ResponseConstant.TAG_DATA,file);
            return null;
        }
        log.info("上传文件成功");
        ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "上传文件成功", ResponseConstant.TAG_DATA,"成功");
        return path;
    }

   //上传多个文件
    public static String uploadFiles(String sufPath, MultipartFile [] files){
        Map<String, Object> resultMap = new HashMap<>();
        //判断文件是否为空
        String path = ResponseConstant.PRE_PATH + "/" + sufPath;
        File dir = new File(path);
        if(files.length < 1) {
            //判断文件目录是否存在，否则自动生成(这里文件上传的路径组成部分为系统Id)
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            try {
                //将文件保存到指点目录；
                //遍历文件数组执行上传
                for (int i =0;i<files.length;i++) {
                    if(files[i] != null) {
                        //调用上传方法
                        File newFile = new File(path +"/"+ files[i].getOriginalFilename());
                        files[i].transferTo(newFile);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                log.error("服务器异常！");
                return null;
            }
        }else{
            log.error("上传文件为空！");
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.FAIL, "上传文件为空", ResponseConstant.TAG_DATA,files);
            return null;
        }
        log.info("上传文件成功");
        ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "上传文件成功", ResponseConstant.TAG_DATA,"成功");
        return path;
    }


    /**
     * 文件流转base64
     *
     * @param in InputStream
     * @return
     */
    public static String fileToBase64(InputStream in) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Base64.encode(data);
    }

    /**
     * base64 转file
     *
     * @param base64 字符串
     * @return
     */
    public static File base64ToFile(String base64) {
        if (base64 == null || "".equals(base64)) {
            return null;
        }
        byte[] buff = Base64.decode(base64);
        File file = null;
        FileOutputStream fout = null;
        try {
            file = File.createTempFile("tmp", null);
            fout = new FileOutputStream(file);
            fout.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }


    //==============================================================================

    /*
     * 方式1;以流的形式下载文件
     *
     *  */
    public static void download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            response.setCharacterEncoding("utf-8");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            //toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    //下载本地文件
    public static void downloadLocal(HttpServletResponse response,String path) throws FileNotFoundException {
        // 下载本地文件
        String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        InputStream inStream = new FileInputStream("c:/Operator.doc");// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //下载网络文件
    public static void downloadNet(HttpServletResponse response) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("windine.blogdriver.com/logo.gif");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("c:/abc.gif");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //支持在线预览
    public static void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }








    //用上面三种方法就行了
    public static void downloadFile(HttpServletResponse response,String fileName,String path){
        if (fileName != null) {
            //设置文件路径
            File file = new File(path);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    //另外一种下载方法，差不多
    public static void download2(String path,HttpServletResponse response){
        File file;
        if(path != null){
            file=new File(path);
            response.reset();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition","attachment;filename="+file.getName());
            byte[] buff =new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os =response.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(file));
                int i =0;
                while ((i = bis.read(buff)) != -1){
                    os.write(buff,0,i);
                    os.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
