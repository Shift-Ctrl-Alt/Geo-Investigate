package com.oymn.geoinvestigate.handler;

import com.oymn.geoinvestigate.common.PermissionEnums;
import com.oymn.geoinvestigate.dao.pojo.LoginUser;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 判断用户是否有访问该路径的权限
 */
//@Component
public class PathAccessDecisionManager implements AccessDecisionManager {

    ///拒绝访问权限名称
    private static final String BASE_REFUSE_NAME = PermissionEnums.ROLE_REFUSE.name();

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        
        //configAttributes存放着权限字符串
        if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }

        //遍历访问路径所需要的权限
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while(iterator.hasNext()){
            ConfigAttribute ca = iterator.next();
            String needPermission = ca.getAttribute();
            
            //允许匿名访问
            if(PermissionEnums.ROLE_ANONYMOUS.name().equalsIgnoreCase(needPermission)){
                return ;
            }
            
            //该路径不允许任何人访问  或者  该路径有错误，不存在
            if(BASE_REFUSE_NAME.equalsIgnoreCase(needPermission)){
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("资源信息不存在");
                } else{
                    throw new AccessDeniedException("权限不足");
                }
            }

            //判断用户是否拥有该权限
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            Collection<? extends GrantedAuthority> authorities = loginUser.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equalsIgnoreCase(needPermission)){
                    return ;
                }
            }
            
            //如果当前请求没有验证，返回未验证异常
            if (authentication instanceof AnonymousAuthenticationToken) {
                throw new AccessDeniedException("用户未登录");
            }
            throw new AccessDeniedException("权限不足!");
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
