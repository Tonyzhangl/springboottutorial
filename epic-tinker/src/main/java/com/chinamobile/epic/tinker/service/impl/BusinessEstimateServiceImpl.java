package com.chinamobile.epic.tinker.service.impl;

//import com.chinamobile.elephant.model.entity.User;
import com.chinamobile.epic.tinker.common.constants.ResponseConstant;
import com.chinamobile.epic.tinker.common.constants.StatusEnum;
import com.chinamobile.epic.tinker.common.util.FileUtil;
import com.chinamobile.epic.tinker.common.util.ResponseMapUtil;
import com.chinamobile.epic.tinker.dao.BusinessEstimateMapper;
import com.chinamobile.epic.tinker.dao.ItemBusinessMapper;
import com.chinamobile.epic.tinker.dao.TenantMapper;
import com.chinamobile.epic.tinker.entity.BusinessEstimate;
import com.chinamobile.epic.tinker.entity.Role;
import com.chinamobile.epic.tinker.entity.TenantFile;
import com.chinamobile.epic.tinker.service.BusinessEstimateService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class BusinessEstimateServiceImpl implements BusinessEstimateService {
    @Autowired
    private BusinessEstimateMapper businessEstimateMapper;
    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private ItemBusinessMapper itemBusinessMapper;

    @Override
    public BusinessEstimate selectStatusByBusinessId(String BusinessId) {
        return businessEstimateMapper.selectStatusByBusinessId(BusinessId);
    }

    //新增用户维度审批的业务系统
//    @Override
//    public Map<String, Object> insert(Map<String,Object>map,  MultipartFile [] files) {
//        String businessId = String.valueOf(map.get("businessId").toString());
//        //先判断改业务系统有没有是否正在审批之中
//        BusinessEstimate result = selectStatusByBusinessId(businessId);
//        if(result != null && result.getStatus()<3){
//            map.clear();
//            ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "申请失败，该业务系统还在审批之中", ResponseConstant.TAG_DATA,"申请失败，该业务系统还在审批之中");
//            return map;
//        }else{
//            for(int i =0;i<files.length;i++){
//                Map param = new HashMap();
//                FileUtil.uploadFile(businessId,files[i]);
//                String path = ResponseConstant.PRE_PATH+"/"+businessId;
//                TenantFile tenantFile = new TenantFile();
//                String attachedId = UUID.randomUUID().toString().replace("-", "");
//                tenantFile.setId(attachedId);
//                tenantFile.setRelationId(businessId);
//                tenantFile.setFileName(files[i].getOriginalFilename());
//                tenantFile.setFileSize(String.valueOf(files[i].getSize()));
//                tenantFile.setFileType(files[i].getContentType());
//                tenantFile.setBusinessId(businessId);
//                tenantFile.setUrl(path+"/"+files[i].getOriginalFilename());
//                tenantMapper.insertFile(tenantFile);
//                param.put("id", UUID.randomUUID().toString().replace("-", ""));
//                param.put("bussinessId",businessId);
//                param.put("attacheId",attachedId);
//                tenantMapper.insertBusinessFile(param);
//                param.clear();
//            }
//            //获取当前登录用户，先这么写，以后就不这么写了，从别的接口获取；
//            User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            BusinessEstimate businessEstimate =new BusinessEstimate();
//            businessEstimate.setId(UUID.randomUUID().toString().replace("-", ""));
//            businessEstimate.setUserId(user.getId());
//            businessEstimate.setBusinessId(businessId);
//            businessEstimate.setCreateDate(new Date());
//            businessEstimate.setStatus(StatusEnum.STAGE_ONE.getIndex());
//            businessEstimate.setStatusText(StatusEnum.STAGE_ONE.getName());
//            businessEstimate.setDescription(map.get("description").toString());
//            businessEstimate.setSource(0);
//            businessEstimate.setBusinessName("根据businessId从平台获取到的businessName");
//            businessEstimate.setOrgId("根据businessId从平台获取到的orgId");
//            businessEstimate.setOrgName("根据businessId从平台获取到的orgName");
//            int a = businessEstimateMapper.insert(businessEstimate);
//            map.clear();
//            if(a==1){
//                ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "申请成功！", ResponseConstant.TAG_DATA, businessEstimate);
//            }else{
//                ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "申请失败！", ResponseConstant.TAG_DATA, businessEstimate);
//            }
//            return map;
//        }
//
//    }

    //查询所有审批的业务系统
//    @Override
//    public Map<String, Object> selectListByUserId(Map map) {
//        // 获取当前用户的权限和角色列表,如果是超级管理员，则可以查看所有的系统审核,对接的时候应该是type，当type为2，则为运营，则可以看所有的
//        com.chinamobile.epic.tinker.entity.User user = (com.chinamobile.epic.tinker.entity.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Role> roles = ((com.chinamobile.epic.tinker.entity.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAuthorities();
//        Role role = null;
//        for (int i = 0; i < roles.size(); i++) {
//            if (roles.get(i).getName().equals("super_admin")) {
//                role = roles.get(i);
//            }
//        }
//        map.put("userId", user.getId());
//        map.put("role", role);
//        Map <String, Object> resultMap =new HashMap();
//        if(map.get("role")!=null){
//            map.remove("userId");
//        }
//        if(map.get("pageNum")==null||map.get("pageNum").equals("")){
//            List<Map> maps;
//            maps =businessEstimateMapper.selectListByUserId(map);
//            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "查询成功", ResponseConstant.TAG_DATA,maps);
//        }else{
//            PageInfo<List<Map>> pageInfo = PageHelper.startPage(Integer.parseInt(map.get("pageNum").toString()), Integer.parseInt(map.get("pageSize").toString()))
//                    .doSelectPageInfo(new ISelect() {
//                        @Override
//                        public void doSelect() {
//
//                            businessEstimateMapper.selectListByUserId(map);}
//                    });
//            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "查询成功", ResponseConstant.TAG_DATA,pageInfo);
//        }
//        return resultMap;
//    }

    //新增租户维度审批的业务系统
//    @Override
//    public Map<String, Object> insertOrgBusiness(Map map) {
//        //获取当前登录用户，先这么写，以后就不这么写了，从别的接口获取；
//        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        BusinessEstimate businessEstimate =new BusinessEstimate();
//        businessEstimate.setId(UUID.randomUUID().toString().replace("-", ""));
//        businessEstimate.setUserId(user.getId());
//        //先判断改业务系统有没有是否正在审批之中
//        String businessId = String.valueOf(map.get("orgId").toString());
//        BusinessEstimate result = selectStatusByBusinessId(businessId);
//        if(result != null && result.getStatus()<3){
//            map.clear();
//            ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "申请失败，该业务系统还在审批之中", ResponseConstant.TAG_DATA,"失败");
//            return map;
//        }
//        //因为是租户维度，所以business和org是同样的数据
//        businessEstimate.setBusinessId(businessId);
//        businessEstimate.setOrgId(businessId);
//        businessEstimate.setBusinessName("根据businessId从平台获取到的orgName");
//        businessEstimate.setOrgName("根据businessId从平台获取到的orgName");
//        businessEstimate.setCreateDate(new Date());
//        businessEstimate.setStatus(StatusEnum.STAGE_ONE.getIndex());
//        businessEstimate.setStatusText(StatusEnum.STAGE_ONE.getName());
//        businessEstimate.setDescription(map.get("description").toString());
//        businessEstimate.setSource(1);
//        int a = businessEstimateMapper.insert(businessEstimate);
//        map.clear();
//        if(a==1){
//            ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "申请成功！", ResponseConstant.TAG_DATA, businessEstimate);
//        }else{
//            ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "申请失败！", ResponseConstant.TAG_DATA, businessEstimate);
//        }
//        return map;
//    }

    //查看审批的业务系统详情
    @Override
    public Map<String,Object> selectDetailById(String id) {
        Map<String,Object>resultMap =new HashMap<>();
        BusinessEstimate businessEstimate = businessEstimateMapper.selectDetailById(id);
        if(businessEstimate != null){
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "查询成功！", ResponseConstant.TAG_DATA,businessEstimate);
        }else{
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.FAIL, "查询失败！", ResponseConstant.TAG_DATA,id);
        }
        return resultMap;
    }


    @Override
    @Transactional
    public  Map<String,Object> delete(String id) {
        businessEstimateMapper.delete(id);
        Map<String,Object>map =new HashMap();
        map.put("estimateId",id);
        if( itemBusinessMapper.selectByEstimateId(map).size()>0){
            map.clear();
            if(itemBusinessMapper.deleteItem(id)>0){
                if(itemBusinessMapper.deleteItemComment(id)>0){
                    ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "删除成功！", ResponseConstant.TAG_DATA,"删除成功");
                }else{
                    ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "删除失败！", ResponseConstant.TAG_DATA,"删除失败");
                }
            }
        }else{
            map.clear();
            ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "删除成功！", ResponseConstant.TAG_DATA,"删除成功");
        }
        return map;
    }
}
