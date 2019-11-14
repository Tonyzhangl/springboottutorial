package com.chinamobile.epic.tinker.dao;

import com.chinamobile.epic.tinker.entity.BusinessEstimate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BusinessEstimateMapper {
    int insert(BusinessEstimate businessEstimate);
    List<Map> selectListByUserId(Map map);
    void delete(@Param("id") String id);
    BusinessEstimate selectDetailById(@Param("id") String id);
    int updateBusinessEstimate(Map map);
    Map getOrgBusinessEstimate(@Param("id") String id);
    BusinessEstimate selectStatusByBusinessId(@Param("businessId") String businessId);
    List<Map> selectOrgListByUserId(Map map);


}
