package com.kirago.cache.penetration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirago.cache.penetration.entity.DO.Item;
import com.kirago.cache.penetration.mapper.ItemMapper;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CachePassService {
    
    private static final Logger logger = LoggerFactory.getLogger(CachePassService.class);
    
    @Autowired
    private ItemMapper itemMapper;
    
    private RedisTemplate redisTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private static final String keyPrefix = "item:";
    
    public Item getItemInfo(String itemCode) throws Exception{
        Item item = null;
        final String key = keyPrefix+itemCode;
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(redisTemplate.hasKey(key)){
            logger.info("---获取商品详情-缓存中存在该商品: 商品编号为 {}", itemCode);
            Object res = valueOperations.get(key);
            if(res != null && Strings.isNotBlank(res.toString())) {
                item = objectMapper.readValue(res.toString(), Item.class);
            }
        }else {
                logger.info("---在缓存中没有找到商品: 商品编号为 {}", itemCode);
                item = itemMapper.selectByCode(itemCode);
                if(item != null) {
                    valueOperations.set(key, objectMapper.writeValueAsString(item.toString()));
                }else {
                    valueOperations.set(key,"", 30L, TimeUnit.MINUTES);
                }
            }
       return item; 
    }
    
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
}
