package com.kirago.chapter16.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.kirago.chapter16")
@EnableScheduling
public class TaskSchedulerConfig {
}
