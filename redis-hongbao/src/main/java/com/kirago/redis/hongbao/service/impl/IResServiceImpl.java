package com.kirago.redis.hongbao.service.impl;

import com.kirago.redis.hongbao.entity.DO.RedDetail;
import com.kirago.redis.hongbao.entity.DO.RedRecord;
import com.kirago.redis.hongbao.entity.DTO.RedPacketDto;
import com.kirago.redis.hongbao.mapper.RedDetailMapper;
import com.kirago.redis.hongbao.mapper.RedRecordMapper;
import com.kirago.redis.hongbao.mapper.RedRobRecordMapper;
import com.kirago.redis.hongbao.service.IRedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@EnableAsync
public class IResServiceImpl implements IRedService {
    private static final Logger logger = LoggerFactory.getLogger(IResServiceImpl.class);
    
    @Autowired
    private RedRecordMapper redRecordMapper;
    
    @Autowired
    private RedDetailMapper redDetailMapper;
    
    @Autowired
    private RedRobRecordMapper redRobRecordMapper;
    
    
    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void recordRedPacket(RedPacketDto redPacketDto,String redId, List<Integer> list) throws Exception{
        RedRecord redRecord = new RedRecord();
        redRecord.setUserId(redPacketDto.getUserId());
        redRecord.setAmount(BigDecimal.valueOf(redPacketDto.getAmount()));
        redRecord.setRedPackage(redId);
        redRecord.setTotal(redPacketDto.getTotal());
        redRecord.setCreateTime(new Date());
        redRecordMapper.insertSelective(redRecord);
        RedDetail detail;
        for(Integer i:list){
            detail = new RedDetail();
            detail.setRecordId(redRecord.getId());
            detail.setAmount(redRecord.getAmount());
            detail.setCreateTime(new Date());
            redDetailMapper.insertSelective(detail);
        }
    }
    
    @Override
    @Async
    public void recordRobRedPacket(Integer userId,String redId,BigDecimal amount)throws Exception{
        
    }
    
}
