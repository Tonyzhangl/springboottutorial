package com.kirago.chapter06.controller;

import com.kirago.chapter06.Inquirer;
import com.kirago.chapter06.entity.Goodz;
import com.kirago.chapter06.entity.QGoodz;
import com.kirago.chapter06.jpa.GoodJpa;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/5 11:38 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@RestController
public class QueryController
{
    @Autowired
    private GoodJpa goodJPA;

    //注入EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<Goodz> list()
    {
        //querydsl查询实体
        QGoodz _good = QGoodz.goodz;
        //构建JPA查询对象
        JPAQuery<Goodz> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(_good)
                //查询表
                .from(_good)
                //查询条件
                .where(_good.type.id.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
    }

    /**
     * spring data jpa 整合querydsl完成查询
     * @return
     */
    @RequestMapping(value = "/join")
    public List<Goodz> join()
    {
        //querydsl查询实体
        QGoodz _good = QGoodz.goodz;
        //自定义查询对象
        Inquirer inquirer = new Inquirer();
        //添加查询条件
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buidleQuery()));
    }
}

