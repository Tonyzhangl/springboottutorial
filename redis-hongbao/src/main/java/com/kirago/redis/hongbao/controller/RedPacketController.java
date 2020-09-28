package com.kirago.redis.hongbao.controller;

import com.kirago.redis.hongbao.constant.StatusCode;
import com.kirago.redis.hongbao.entity.DTO.RedPacketDto;
import com.kirago.redis.hongbao.service.IRedPacketService;
import com.kirago.redis.hongbao.util.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class RedPacketController {
    
    private static final Logger logger = LoggerFactory.getLogger(RedPacketController.class);
    
    private static final String prefix = "red/packet";
    
    @Autowired
    private IRedPacketService redPacketService;
    
    @PostMapping(value = prefix+"/hand/out")
    public BaseResponse handOut(@Validated @RequestBody RedPacketDto redPacketDto, BindingResult result){
        if(result.hasErrors()){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            String redId = redPacketService.handOut(redPacketDto);
            response.setData(redId);
        }catch (Exception e){
            logger.error("发红包异常： dto={}", redPacketDto, e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getStatus(), e.getMessage());
        }
        return response;
    }
    
    @GetMapping(value = prefix+"/rob")
    public BaseResponse rob(@RequestParam Integer userId, @RequestParam String redId){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            BigDecimal result = redPacketService.rob(userId, redId);
            if(result != null){
                response.setData(result);
            }else {
                response = new BaseResponse(StatusCode.Fail.getStatus(), "红包抢完了");
            }
        }catch (Exception e){
            logger.error("抢红包发生异常: userId={} redId={}", userId, redId,e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getStatus(), e.getMessage());
        }
        return response;
    }
}
