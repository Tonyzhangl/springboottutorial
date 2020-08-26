package com.kirago.redis.command.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Value("${redis.address}")
    public String address;
    
    @Value("${redis.port}")
    public int port;
}
