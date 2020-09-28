package com.kirago.redis.hongbao.entity.DTO;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
public class RedPacketDto {
    private Integer userId;
    
    @NonNull
    private Integer total;
    
    @NonNull
    private Integer amount;
}
