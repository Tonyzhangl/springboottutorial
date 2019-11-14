package com.kirago.redis.template.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTemplateDemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateDemoApplicationTests.class);

    @Autowired
    private UserRedis userRedis;

    @Before
    public void setup() {
        User user = new User();
        user.setName("kirago");
        user.setAddress("addresstest");
        userRedis.delete(this.getClass().getName() + ":userByname: " + user.getName());
        userRedis.add(this.getClass().getName() + ":userByname: " + user.getName(), 10L, user);
    }

    @Test
    public void get() {
        User user = userRedis.get(this.getClass().getName() + ":userByname: user");
        Assert.assertNotNull(user);

    }

}
