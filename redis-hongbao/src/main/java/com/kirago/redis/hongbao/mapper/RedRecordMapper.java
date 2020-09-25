package com.kirago.redis.hongbao.mapper;

import com.kirago.redis.hongbao.entity.DO.RedRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RedRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedRecord record);

    int insertSelective(RedRecord record);

    RedRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedRecord record);

    int updateByPrimaryKey(RedRecord record);
}