package com.kirago;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/6 10:56 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Chapter07Application.class);
    }

}
