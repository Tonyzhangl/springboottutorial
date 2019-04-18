package com.kirago.chapter21.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    public void setMyAccessDesiginManager(MyAccessDesignManager myAccessDesiginManager){
        super.setAccessDecisionManager(myAccessDesiginManager);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        invoke(filterInvocation);
    }

    public void invoke(FilterInvocation filterInvocation) throws IOException, ServletException{

        InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
        try{
            //执行下一个拦截器
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
        }finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public Class<?> getSecureObjectClass(){
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource(){
        return this.filterInvocationSecurityMetadataSource;
    }
}
