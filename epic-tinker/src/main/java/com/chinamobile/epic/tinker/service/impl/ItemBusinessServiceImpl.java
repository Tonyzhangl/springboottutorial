package com.chinamobile.epic.tinker.service.impl;

import com.chinamobile.epic.tinker.common.constants.ResponseConstant;
import com.chinamobile.epic.tinker.common.constants.StatusEnum;
import com.chinamobile.epic.tinker.common.util.ResponseMapUtil;
import com.chinamobile.epic.tinker.controller.TenantController;
import com.chinamobile.epic.tinker.dao.BusinessEstimateMapper;
import com.chinamobile.epic.tinker.dao.ItemBusinessMapper;
import com.chinamobile.epic.tinker.dao.ItemTemplateMapper;
import com.chinamobile.epic.tinker.entity.ItemBusiness;
import com.chinamobile.epic.tinker.entity.ItemTemplate;
import com.chinamobile.epic.tinker.entity.Role;
import com.chinamobile.epic.tinker.entity.User;
import com.chinamobile.epic.tinker.service.ItemBusinessService;
import com.chinamobile.epic.tinker.vo.ItemBusinessVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {
    private static final Logger logger = LoggerFactory.getLogger(ItemBusinessServiceImpl.class);
    @Autowired
    private ItemBusinessMapper itemBusinessMapper;
    @Autowired
    private BusinessEstimateMapper businessEstimateMapper;
    @Autowired
    private ItemTemplateMapper itemTemplateMapper;


    @Override
    public List<Map> selectByEstimateId(Map map) {
        return itemBusinessMapper.selectByEstimateId(map);
    }




    @Override
    @Transactional
    public Map<String,Object> updateItemBusiness(Map paramMap, ItemBusinessVo itemBusinessVo) {
        Map<String,Object> map =new HashMap<>();
        for(ItemBusiness itemBusiness: itemBusinessVo.getItem()){
            if(itemBusiness.getCommentResult()==null||itemBusiness.getCommentResult()==""){
                logger.error("该次评估中有指标没有打分，请重新评估！",itemBusinessVo);
                ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "该次评估中有指标没有打分，请重新评估！", ResponseConstant.TAG_DATA,itemBusinessVo);
                return map;
            }
        }
        //修改逻辑，先查出数据库中所有该表的相关修改记录，在根据前端修改的阶段来判断可不可以给他修改
       // User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user =new User();
        map.put("estimateId",paramMap.get("estimateId"));
        //根据数据库中的字段，来判断，当前修改的评估如果是已经上一阶段的，那么就无权在修改了
        map.put("categoryType",Integer.parseInt(paramMap.get("categoryType").toString())+1);
       //找到该系统某阶段的所有三级指标评分
        List<Map> resultMaps = selectByEstimateId(map);
        String commentsId;
        ItemBusiness itemBusiness =new ItemBusiness();
        if(resultMaps != null &&resultMaps.size()>0){
            //则不可以修改
            ResponseMapUtil.makeResultMap(map, ResponseConstant.FAIL, "该阶段已经修改完成，不能再次修改！", ResponseConstant.TAG_DATA,"阶段"+paramMap.get("categoryType")+"已经修改完成，不能再次修改！");
            return  map;
        }else{
            resultMaps.clear();
            resultMaps =  selectByEstimateId(paramMap);
            Map commentsMap;
            commentsMap = itemBusinessMapper.selectItemComment(paramMap);
            if(!commentsMap.isEmpty()){
                commentsMap.put("totalCommentResult",paramMap.get("totalCommentResult"));
                commentsMap.put("totalDescription",paramMap.get("totalDescription"));
                itemBusinessMapper.updateItemComment(commentsMap);
                for(int i = 0;i<itemBusinessVo.getItem().size();i++){
                      itemBusiness.setCategoryType(itemBusinessVo.getCategoryType());
                      itemBusiness.setCommentResult(itemBusinessVo.getItem().get(i).getCommentResult());
                      itemBusiness.setItemCommentsId(itemBusinessVo.getItem().get(i).getId());
                      itemBusiness.setUserId(user.getId());
                      for(int j =0;j<resultMaps.size();j++){
                          if(resultMaps.get(j).get("template_id").equals(itemBusinessVo.getItem().get(i).getId())){
                              itemBusiness.setId(resultMaps.get(i).get("id").toString());
                          }
                      }
                      itemBusinessMapper.updateItem(itemBusiness);
                }
                ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "修改成功！", ResponseConstant.TAG_DATA,itemBusinessVo);
            }else{
                commentsId =UUID.randomUUID().toString().replace("-", "");
                paramMap.put("id",commentsId);
                paramMap.put("userId",user.getId());
                itemBusinessMapper.insertItemComments(paramMap);
                for(int i=0;i<itemBusinessVo.getItem().size();i++){
                    itemBusiness.setId(UUID.randomUUID().toString().replace("-", ""));
                    itemBusiness.setTemplateId(itemBusinessVo.getItem().get(i).getId());
                    //这个Id是模板Id
                    ItemTemplate itemTemplate = itemTemplateMapper.selectById(itemBusinessVo.getItem().get(i).getId());
                    itemBusiness.setItemWeight(itemTemplate.getItemWeight());
                    itemBusiness.setLevelSet(itemTemplate.getLevelSet());
                    itemBusiness.setUserId(user.getId());
                    itemBusiness.setPrimaryItemName(itemTemplate.getPrimaryItemName());
                    itemBusiness.setSecondaryItemName(itemTemplate.getSecondaryItemName());
                    itemBusiness.setItemName(itemTemplate.getItemName());
                    itemBusiness.setEstimateId(itemBusinessVo.getEstimateId());
                    itemBusiness.setItemDesc(itemTemplate.getItemDesc());
                    itemBusiness.setCommentResult(itemBusinessVo.getItem().get(i).getCommentResult());
                    itemBusiness.setCategoryType(itemBusinessVo.getItem().get(i).getCategoryType());
                    itemBusiness.setItemCommentsId(commentsId);
                    itemBusiness.setCreateDate(new Date(System.currentTimeMillis()));
                    itemBusiness.setSource(itemBusinessVo.getItem().get(i).getSource());
                    itemBusinessMapper.insertItem(itemBusiness);
                }
                //如果是新增，则要根据这次修改的状态来更新t_business_estimate表的status
                map.put("status",itemBusiness.getCategoryType());
                map.put("statusText", StatusEnum.getName(itemBusiness.getCategoryType()));
                map.put("id",paramMap.get("estimateId"));
                businessEstimateMapper.updateBusinessEstimate(map);
                map.clear();
                ResponseMapUtil.makeResultMap(map, ResponseConstant.SUCCESS, "修改成功！", ResponseConstant.TAG_DATA,itemBusinessVo);
            }
        }
        return map;
    }


    @Override
    public Map<String,Object> selectByCategoryType(Map map) {
        List<Map> list;
        Map <String,Object>resultMap =new HashMap();
        list= itemBusinessMapper.selectByCategoryType(map);
        if(!list.isEmpty()){
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "查询成功！", ResponseConstant.TAG_DATA,list);
        }else{
            List<ItemTemplate> templateList;
            templateList = itemTemplateMapper.getItemTemplate(map);
            ResponseMapUtil.makeResultMap(resultMap, ResponseConstant.SUCCESS, "查询成功！", ResponseConstant.TAG_DATA,templateList);
        }
        return  resultMap;
    }
}
