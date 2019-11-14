package com.chinamobile.epic.tinker.service;

import com.chinamobile.epic.tinker.entity.TenantFile;
import org.springframework.web.multipart.MultipartFile;

public interface TenantService {

    String modifyFile(MultipartFile file, String businessId);

    void insertFile(TenantFile tenantFile);
    //List<Map<String, Object>> getAvgCount(String orgId);
}
