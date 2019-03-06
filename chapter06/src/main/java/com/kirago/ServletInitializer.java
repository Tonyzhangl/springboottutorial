package com.kirago;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/5 11:29 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(Chapter06Application.class);
    }
}
