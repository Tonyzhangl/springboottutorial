package com.chinamobile.epic.tinker.service;

import com.chinamobile.epic.tinker.entity.ItemBusiness;
import com.chinamobile.epic.tinker.vo.ItemBusinessVo;

import java.util.List;
import java.util.Map;

public interface ItemBusinessService {

    List<Map> selectByEstimateId(Map map);


    /**
     * 修改数据
     *
     * @param map
     * @return
     */
    Map<String,Object> updateItemBusiness(Map map, ItemBusinessVo itemBusinessVo);





    Map<String,Object> selectByCategoryType(Map map);
}
