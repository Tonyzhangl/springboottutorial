package com.kirago.jedis.util.demo.controller;

import com.kirago.jedis.util.demo.constant.RedisConstant;
import com.kirago.jedis.util.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/setredis",method = RequestMethod.POST)
    public void setRedis(){
        redisUtil.set("20191029", "what a fucking day", RedisConstant.DATABASE1);
        Long resExpire = redisUtil.expire("20191029", 60, RedisConstant.DATABASE1);//设置key过期时间
        System.out.println(">>>>> set redis key value >>>>> 成功");
    }

    @RequestMapping(value = "/getredis", method = RequestMethod.GET)
    public void getRedis() {
        String v1 = redisUtil.get("20191029", RedisConstant.DATABASE1);
        System.out.println(">>>>>>" + v1 + ">>>>>");
        try {
            Thread.sleep(5000);
            String v2 = redisUtil.get("20191029", RedisConstant.DATABASE1);
            System.out.println(v2);
        }catch (Exception e) {
            e.printStackTrace();
        }
        String v3 = redisUtil.get("20191029", RedisConstant.DATABASE1);
        System.out.println(v3);

    }

}
