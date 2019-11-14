package com.chinamobile.epic.tinker.controller;


import com.chinamobile.epic.tinker.common.constants.ResponseConstant;
import com.chinamobile.epic.tinker.common.util.ResponseMapUtil;
import com.chinamobile.epic.tinker.entity.BusinessEstimate;
import com.chinamobile.epic.tinker.entity.ItemBusiness;
import com.chinamobile.epic.tinker.entity.Role;
import com.chinamobile.epic.tinker.entity.User;
//import com.chinamobile.epic.tinker.service.BusinessEstimateService;
//import com.chinamobile.epic.tinker.service.ItemTemplateService;
import com.chinamobile.epic.tinker.service.BusinessEstimateService;
import com.chinamobile.epic.tinker.service.ItemBusinessService;
import com.chinamobile.epic.tinker.service.TenantService;
import com.chinamobile.epic.tinker.vo.ItemBusinessVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 租户成熟度控制器
 */

@Api(value = "租户成熟度相关的API")
@RestController
@RequestMapping(value = "/api/tenant")
public class TenantController {

    private static final Logger logger = LoggerFactory.getLogger(TenantController.class);
    private static String PRE_PATH = "/opt/businessFile";

    @Autowired
    private TenantService tenantService;
    //TODO 需要修改
    @Autowired
    private ItemBusinessService itemBusinessService;
   // TODO需要修改

    @Autowired
    private BusinessEstimateService businessEstimateService;
//    TODO 需要修改
//    @Autowired
//    private ItemTemplateService itemTemplateService;

    @GetMapping(value = "/test")
    public String test() {
        return "xxxx";
    }


    /**
     * 部门下业务系统的平均指标
     *
     * @param orgId 组织部门ID
     * @return
     */
//    @ApiOperation(value = "部门下业务系统的平均指标")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "orgId", value = "组织ID", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/avg_comments")
//    public Map<String, Object> getCommentsAvg(@RequestParam("orgId") String orgId) {
//        Map<String, Object> resultMap = new HashMap<>();
//        ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "获得指标周期性平均指标",
//                ResponseConstant.TAG_DATA, tenantService.getAvgCount(orgId));
//        return resultMap;
//    }

    /**
     * 申请业务系统评估
     * @param
     * @return
     */
//    @ApiOperation(value = "申请业务评估")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "businessId", value = "业务系统ID", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "description", value = "描述", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType = "body", name = "files", dataType = "MultipartFile", required = true, value = "附件(可上传多个)")
//    })
//    @PostMapping("/applyEstimate")
//    public Map<String, Object> applyEstimate(
//            @RequestParam("businessId") String businessId,
//            @RequestParam("description") String description,
//            @RequestParam("files") MultipartFile[] files) {
//        Map paramMap = new HashMap();
//        paramMap.put("businessId", businessId);
//        paramMap.put("description", description);
//        paramMap.put("source", 0);
//        return businessEstimateService.insert(paramMap, files);
//    }

    ;


    /**
     * 查询该用户的提交评估的系统
     * @param source
     * @return
     */
//    @ApiOperation(value = "查询该用户或者部门的提交评估的系统列表，用source来区别")
//    @ApiImplicitParams({@ApiImplicitParam(name = "source", value = "source", required = true, dataType = "String"),})
//    @GetMapping("/getBusinessEstimateList")
//    public Map<String, Object> getBusinessByUserList(
//            @RequestParam("source") String source,
//            @RequestParam(value = "pageNum", required = false) Integer pageNum,
//            @RequestParam(value = "pageSize", required = false) Integer pageSize
//    ) {
//        Map<String, Object> map = new HashMap();
//        map.put("source", source);
//        map.put("pageNum", pageNum);
//        map.put("pageSize", pageSize);
//        return businessEstimateService.selectListByUserId(map);
//    };


     /**
      * 申请部门评估
      * @param map
      * @return
      */
    // TODO 这边 ordId 是否可以拿到部门ID
//    @ApiOperation(value = "申请部门评估")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "orgId", value = "部门Id", required = true, dataType = "String"),
//    })
//    @PostMapping(value = "/applyOrgEstimate")
//    public Map<String, Object> getBusinessByOrg( @RequestBody Map<String, String> map) {
//        return businessEstimateService.insertOrgBusiness(map); }


    /**
     * 查询该用户的提交评估的系统
     * @param  id
     * @return
     */
    @ApiOperation(value = "查询该用户的提交评估的系统的详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "评估系统的Id", required = true, dataType = "String"),})
    @GetMapping("/getBusinessEstimate")
    public  Map<String, Object> getBusiness(
            @RequestParam("id") String id
    ){return businessEstimateService.selectDetailById(id);}

    /**
     * 删除相关评估系统详情
     * @param id
     * @return
     */
    @ApiOperation(value = "删除评估的系统")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),})
    @DeleteMapping("/deleteBusinessEstimate")
    public Map<String,Object> deleteItemIdBusiness(@RequestParam("id") String id){
        return businessEstimateService.delete(id);
    }


    /**
     * 展示带评估系统的模板，分事前事中时候三个模板(默认展示事前)，还有分租户维度还是业务系统维度
     * @param estimateId categoryType source
     * @return
     */

    @ApiOperation(value = "查询评估的系统模板和评估详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "estimateId", value = "系统的ID", required = true),
            @ApiImplicitParam(name = "categoryType", value = "表明事前事中还是事后", required = true),
            @ApiImplicitParam(name = "source", value = "表明维度", required = true),
    })
    @GetMapping("/getTemplate")
    public Map<String,Object> getTemplate(
            @RequestParam("estimateId") String estimateId ,
            @RequestParam("categoryType") Integer categoryType,
            @RequestParam("source") Integer source){
        Map paramMap = new HashMap();
        paramMap.put("categoryType",categoryType);
        paramMap.put("estimateId",estimateId);
        paramMap.put("source",source);
        return itemBusinessService.selectByCategoryType(paramMap);
    }


    /**
     * 修改相应的评估进度
     * @param itemBusinessVo
     * @return
     */
    @ApiOperation(value = "修改相应的评估进度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemBusinessVo", value = "集合参数，修改的相关新信息(该对象包括修改的系统Id,修改的指标Id，和修改的结果)", required = true),
    })
    @PostMapping("/modifyItemBusiness")
    public Map<String,Object> modifyItemBusiness(
            @RequestBody ItemBusinessVo itemBusinessVo){
        Map paramMap =new HashMap();
        paramMap.put("estimateId",itemBusinessVo.getEstimateId());
        paramMap.put("totalCommentResult",itemBusinessVo.getTotalCommentResult());
        paramMap.put("categoryType",itemBusinessVo.getCategoryType());
        paramMap.put("totalDescription",itemBusinessVo.getTotalDescription());
        return itemBusinessService.updateItemBusiness(paramMap,itemBusinessVo);

    }






//
//    //租户维度的系统评审（其实就是根据部门来获取业务系统来评估相应的系统）
//
//
//
//    /**
//     * 查询该用户的提交评估的系统
//     * @param  source
//     * @return
//     */

//
//    /**
//     * 展示待评估的部门详情
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "查看评估详情")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")})
//    @GetMapping("/getOrgBusinessEstimate")
//    public Map<String,Object>getOrgBusinessEstimate(
//            @RequestParam("id") String id){
//        Map resultMap;
//        resultMap = businessEstimateService.getOrgBusinessEstimate(id);
//        Map <String,Object> map =new HashMap();
//        ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "查询成功！", ResponseConstant.TAG_DATA,resultMap);
//        return map;
//    }
//
//    /**
//     * 查看模板列表
//     * @param  source categoryType
//     * @return
//     */
//    @ApiOperation(value = "查看系统模板列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "source", value = "source", required = true),
//            @ApiImplicitParam(name = "categoryType", value = "categoryType", required = true)
//    })
//    @GetMapping("/getTemplateList")
//    public Map<String ,Object> getTemplateList(
//            @RequestParam("categoryType") Integer categoryType,
//            @RequestParam("source") Integer source
//    ){
//        Map <String,Object>map =new HashMap();
//        map.put("categoryType",categoryType);
//        map.put("source",source);
//        return itemTemplateService.getItemTemplate(map);
//    }
//
//    /**
//     * 增加模板
//     * @param  itemTemplate
//     * @return
//     */
//    @ApiOperation(value = "增加模板")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "template", value = "template", required = true),
//    })
//    @PostMapping("/addItemTemplate")
//    public Map<String ,Object> addItemTemplate(
//            @RequestBody ItemTemplate itemTemplate
//    ){
//        return itemTemplateService.insertItemTemplate(itemTemplate);
//    }
//
//    /**
//     * 修改模板
//     * @param  itemTemplate
//     * @return
//     */
//    @ApiOperation(value = "修改模板")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "template", value = "template", required = true),
//    })
//    @PostMapping("/modifyItemTemplate")
//    public Map<String ,Object> modifyItemTemplate(
//            @RequestBody ItemTemplate itemTemplate
//    ){
//        return itemTemplateService.updateItemTemplate(itemTemplate);
//    }
//
//    /**
//     * 下载附件
//     *
//     * @return
//     * @throws IOException
//     */
//    @ApiOperation(value = "下载附件")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "fileId", value = "附件ID", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/download/{fileId}")
//    public Map<String,Object> downloadFile(@PathVariable("fileId") String fileId, HttpServletResponse response) throws IOException {
//        TenantFile tenantFile;
//        tenantFile = tenantService.getFileById(fileId);
//        FileUtil.download(tenantFile.getUrl(),response);
//        System.out.println(response);
//        Map<String,Object> map =new HashMap<>();
//        return map;
//    }


}
