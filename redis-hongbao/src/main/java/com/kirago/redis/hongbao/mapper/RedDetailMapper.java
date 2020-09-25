package com.kirago.redis.hongbao.mapper;

import com.kirago.redis.hongbao.entity.DO.RedDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RedDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedDetail record);

    int insertSelective(RedDetail record);

    RedDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedDetail record);

    int updateByPrimaryKey(RedDetail record);
}