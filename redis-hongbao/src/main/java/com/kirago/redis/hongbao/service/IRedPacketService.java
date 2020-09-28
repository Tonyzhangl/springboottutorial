package com.kirago.redis.hongbao.service;

import com.kirago.redis.hongbao.entity.DTO.RedPacketDto;

import java.math.BigDecimal;

public interface IRedPacketService {
    String handOut(RedPacketDto redPacketDto) throws Exception;
    
    BigDecimal rob(Integer userId,String redId) throws Exception;
}
