package com.kirago.chapter12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index")
    public String index() {
        logger.info("info测试日志");
        logger.debug("debug测试日志");
        logger.error("error测试日志");
        return "index";
    }
}
