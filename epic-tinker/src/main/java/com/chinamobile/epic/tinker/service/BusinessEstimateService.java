package com.chinamobile.epic.tinker.service;

import com.chinamobile.epic.tinker.entity.BusinessEstimate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface BusinessEstimateService {

    BusinessEstimate selectStatusByBusinessId(String BusinessId);

    //新增用户维度审批的业务系统
//    Map<String, Object> insert(Map<String, Object> map, MultipartFile[] files);

    //查询所有审批的业务系统
//    Map<String, Object> selectListByUserId(Map map);

    //新增租户维度审批的业务系统
//    Map<String, Object> insertOrgBusiness(Map map);

    //查看审批的业务系统详情
    Map<String,Object>selectDetailById(String id);

    Map<String,Object> delete(String id);
}
