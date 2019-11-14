package com.chinamobile.epic.tinker.dao;

import com.chinamobile.epic.tinker.entity.ItemBusiness;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemBusinessMapper {
    int insertItem(ItemBusiness itemBusiness);
    int updateItem(ItemBusiness itemBusiness);
    int deleteItem(@Param("estimateId") String estimateId);
    int deleteItemComment(@Param("estimateId") String estimateId);
    List<Map>selectByCategoryType(Map map);
    Map selectItemComment(Map map);
    int updateItemComment(Map map);
    int insertItemComments(Map map);
    List<Map> selectByEstimateId(Map map);
}
