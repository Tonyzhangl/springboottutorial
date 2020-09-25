package com.kirago.redis.hongbao.mapper;

import com.kirago.redis.hongbao.entity.DO.RedRobRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RedRobRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedRobRecord record);

    int insertSelective(RedRobRecord record);

    RedRobRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedRobRecord record);

    int updateByPrimaryKey(RedRobRecord record);
}