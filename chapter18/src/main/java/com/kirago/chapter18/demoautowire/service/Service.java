package com.kirago.chapter18.demoautowire.service;

import com.kirago.chapter18.demoautowire.dao.MongoDao;
import com.kirago.chapter18.demoautowire.dao.MysqlDao;

public class Service {

    private MysqlDao mysqlDao;

    private MongoDao mongoDao;

    public Service(){}

    public void setMysqlDao(MysqlDao mysqlDao) {
        this.mysqlDao = mysqlDao;
    }

    public void setMongoDao(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

    public MysqlDao getMysqlDao(){
        return mysqlDao;
    }

    public MongoDao getMongoDao() {
        return mongoDao;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t\t\t\t\t{" +
                "mysqlDao=" + mysqlDao +
                ", mongoDao=" + mongoDao +
                '}';
    }
}
