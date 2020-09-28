package com.kirago.redis.hongbao.service;

import com.kirago.redis.hongbao.entity.DTO.RedPacketDto;

import java.math.BigDecimal;
import java.util.List;

public interface IRedService {
    
    void recordRedPacket(RedPacketDto redPacketDto, String redId, List<Integer> list) throws Exception;
    
    void recordRobRedPacket(Integer userId, String redId, BigDecimal amount) throws Exception;
}
