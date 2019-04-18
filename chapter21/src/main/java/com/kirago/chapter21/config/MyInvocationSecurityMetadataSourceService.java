package com.kirago.chapter21.config;

import com.kirago.chapter21.entity.RolePermission;
import com.kirago.chapter21.mapper.PermissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    String name;
    private static final Logger logger = LoggerFactory.getLogger(MyInvocationSecurityMetadataSourceService.class);

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static HashMap<String, Collection<ConfigAttribute>> collectionHashMap = null ;

    /**
     * 返回请求的资源需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException{
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for(Iterator<String> iterator = collectionHashMap.keySet().iterator(); iterator.hasNext();){
            String url = iterator.next();
            if(new AntPathRequestMatcher(url).matches(request)){
                return collectionHashMap.get(url);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes(){
        //初始化 所有资源 对应的角色
        loadResourceDefine();
        return null;
    }
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
//
//        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : collectionHashMap.entrySet()) {
//            allAttributes.addAll(entry.getValue());
//        }
//
//        return allAttributes;
//}

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    public void loadResourceDefine(){

         collectionHashMap = new HashMap<>(16);
        //权限资源 和 角色对应的表  也就是 角色权限 中间表
        List<RolePermission> rolePermissons = permissionMapper.getRolePermissions();

        //某个资源 可以被哪些角色访问
        for (RolePermission rolePermission : rolePermissons) {

            String url = rolePermission.getUrl();
            String roleName = rolePermission.getRoleName();
            ConfigAttribute role = new SecurityConfig(roleName);


            if(collectionHashMap.containsKey(url)){
                collectionHashMap.get(url).add(role);
            }else{
                List<ConfigAttribute> list =  new ArrayList<>();
                list.add(role);
                collectionHashMap.put(url,list);
            }
        }
    }
}
