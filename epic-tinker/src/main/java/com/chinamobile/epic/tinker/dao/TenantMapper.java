package com.chinamobile.epic.tinker.dao;

import com.chinamobile.epic.tinker.entity.TenantFile;

import java.util.Map;

public interface TenantMapper {
    /**
     * 写入附件表
     * @param tenantFile
     * @return
     */
    int insertFile(TenantFile tenantFile);

    /*
    *写入评估系统和附件关系表
    * @param map
    * @return
    * */
    int insertBusinessFile(Map map);
}
