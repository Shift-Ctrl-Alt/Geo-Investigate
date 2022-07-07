package com.oymn.geoinvestigate.handler;

import com.oymn.geoinvestigate.common.PermissionEnums;
import com.oymn.geoinvestigate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import java.util.*;

/**
 * 获取访问该类路径所需要的权限
 * 该类暂时不需要用到
 */
//@Component
public class RolePermissionMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleService roleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        
        //object 中包含用户请求的request 信息
        FilterInvocation invocation = (FilterInvocation) object;
        //获取请求路径url
        String url = invocation.getRequestUrl();
        
        //通过请求路径获取访问该路径所需要的权限列表
        Collection<ConfigAttribute> permissions = roleService.getPermissionByPath(url);
        if(permissions != null && permissions.size() > 0){
            return permissions;
        }
        
        //自定义不存在的访问权限，禁止访问
        return SecurityConfig.createList(PermissionEnums.ROLE_REFUSE.name());
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // TODO
        
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
