package com.chinamobile.epic.tinker.controller;

import com.chinamobile.epic.tinker.service.ExcelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {

//    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);
//
//    @Autowired
//    private ExcelService excelService;
//
//    //业务维度导出按钮
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "estimateId", value = "待审批的Id", dataType = "String"),
//            @ApiImplicitParam(name = "source", value = "source", dataType = "String")
//    })
//    @RequestMapping(value = "/api/excel", method = RequestMethod.GET)
//    @ApiOperation(value = "导出业务维度Excel", notes = "管理员和用户拥有此权限", produces = "application/octet-stream")
//    @ResponseBody
//    public Map<String, Object> downloadExcel1(HttpServletResponse response,
//                                              HttpServletRequest request,
//                                              @RequestParam(value = "estimateId",required = false) String estimateId,
//                                              @RequestParam("source") Integer source
//    ) {
//        Map<String, Object> resultMap = new HashMap<>();
//        log.info("1来到了web层");
//        Map map =new HashMap();
//        map.put("id",estimateId);
//        List<Excel> excelList5 =null;
//        if(source == 0){
//            excelList5= excelService.selectToExcel1(map);
//        }else{
//            excelList5 = excelService.selectToExcel2(map);
//        }
//        //这里两个指标要一致
//        String[] headerName = { "一级指标", "二级指标", "三级指标","权重","指标描述","等级设定","评价结果","备注","类型"};
//        String[] headerKey = { "levelName1", "levelName2", "levelName3","itemWeight","itemDesc","levelSet","commentResult","remark","categoryType"};
//        HSSFWorkbook workbook = null;
//        try {
//            workbook =ExcelUtils.exportExcel(headerName,headerKey,"abc",excelList5,source);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        ExcelUtils.downloadExcel(response, request, workbook);
//        ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "导出成功", ResponseConstant.TAG_DATA, excelList5);
//        return resultMap;
//    }

}
