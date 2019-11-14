package com.chinamobile.epic.tinker.dao;

import com.chinamobile.epic.tinker.entity.ItemTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemTemplateMapper {
    //获取相应的模板
    List<ItemTemplate> getItemTemplate(Map map);

    //获取每一个模板
    ItemTemplate selectById(@Param("id") String id);

    //新增模板
    int insertItemTemplate(ItemTemplate itemTemplate);
    //修改模板
    int updateItemTemplate(ItemTemplate itemTemplate);
}
