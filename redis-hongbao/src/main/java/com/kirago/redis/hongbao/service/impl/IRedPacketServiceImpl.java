package com.kirago.redis.hongbao.service.impl;

import com.kirago.redis.hongbao.entity.DTO.RedPacketDto;
import com.kirago.redis.hongbao.service.IRedPacketService;
import com.kirago.redis.hongbao.util.RedPacketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IRedPacketServiceImpl implements IRedPacketService {
    
    private static final Logger logger = LoggerFactory.getLogger(IRedPacketServiceImpl.class);
    
    private static final String keyPrefix = "redis:red:packet:";
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Override
    public String handOut(RedPacketDto redPacketDto) throws Exception{
        if(redPacketDto.getTotal() > 0 && redPacketDto.getAmount() > 0 ){
            List<Integer> list = RedPacketUtil.divideRedPacket(redPacketDto.getAmount(), redPacketDto.getTotal());
            String timestamp = String.valueOf(System.nanoTime());
            String redId = new StringBuffer().append(keyPrefix).append(redPacketDto.getUserId())
                    .append(":").append(timestamp).toString();
            redisTemplate.opsForList().leftPushAll(redId, list);
            String redTotalKey = redId + ":total";
            redisTemplate.opsForValue().set(redTotalKey, redPacketDto.getTotal());
            
            return redId;
        }else {
            throw new Exception("系统异常-分发红包-参数不合法");
        }
    }
    
    @Override
    public BigDecimal rob(Integer userId, String redId){
        return null;
    }
    
}
