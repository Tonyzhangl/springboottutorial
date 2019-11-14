package com.chinamobile.epic.tinker.service.impl;

import com.chinamobile.epic.tinker.dao.TenantMapper;
import com.chinamobile.epic.tinker.entity.TenantFile;
import com.chinamobile.epic.tinker.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class TenantServiceImpl implements TenantService {
    private static String PRE_PATH = "/opt/businessFile";

    @Autowired
    private TenantMapper tenantMapper;
//    @Autowired
//    private ElephantExtensionClient elephantExtensionClient;


    @Override
    public void insertFile(TenantFile tenantFile) {
        tenantMapper.insertFile(tenantFile);
    }
    @Override
    public String  modifyFile(MultipartFile file, String businessId) {
        String path =PRE_PATH+"/"+businessId;
        TenantFile tenantFile = new TenantFile();
        String attachedId = UUID.randomUUID().toString().replace("-", "");
        tenantFile.setId(attachedId);
        tenantFile.setRelationId(businessId);
        tenantFile.setFileName(file.getOriginalFilename());
        tenantFile.setFileSize(String.valueOf(file.getSize()));
        tenantFile.setFileType(file.getContentType());
        tenantFile.setBusinessId(businessId);
        tenantFile.setUrl(path+"/"+file.getOriginalFilename());
        insertFile(tenantFile);
        return attachedId;
    }
}
