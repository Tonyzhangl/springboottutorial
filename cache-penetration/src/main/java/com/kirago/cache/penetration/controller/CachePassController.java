package com.kirago.cache.penetration.controller;

import com.kirago.cache.penetration.service.CachePassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CachePassController {
    
    private static final Logger logger = LoggerFactory.getLogger(CachePassService.class);
    
    @Autowired
    private CachePassService cachePassService;
    
    @GetMapping(value = "/cache/item/info")
    public Map<String, Object> getItem(@RequestParam String itemCode){
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code", 0);
        resMap.put("msg", "成功");
        try {
            resMap.put("data", cachePassService.getItemInfo(itemCode));
        }catch (Exception e){
            resMap.put("code", -1);
            resMap.put("msg", "失败");
            resMap.put("data", e.getMessage());
        }
        return resMap;
    }
    
    
}
