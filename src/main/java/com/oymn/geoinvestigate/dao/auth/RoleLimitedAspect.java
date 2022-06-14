package com.oymn.geoinvestigate.dao.auth;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.pojo.UserRole;
import com.oymn.geoinvestigate.handler.UserSupport;
import com.oymn.geoinvestigate.service.UserRoleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//用于对角色的接口权限控制
@Aspect
@Order(1)
@Component
public class RoleLimitedAspect {
    
    @Autowired
    private UserSupport userSupport;
    
    @Autowired
    private UserRoleService userRoleService;

    @Pointcut("@annotation(com.oymn.geoinvestigate.dao.auth.RoleLimitedAnnotation)")
    public void check(){
    }

    //注解上所标识的是被限制该接口的角色
    @Before("check() && @annotation(roleLimitedAnnotation)")
    public void doBefore(JoinPoint joinPoint, RoleLimitedAnnotation roleLimitedAnnotation){
        Long userId = userSupport.getCurrentUserId();

        List<UserRole> userRoleList = userRoleService.getUserRoleByUserId(userId);
        String[] allowedRoleCodeList = roleLimitedAnnotation.allowedRoleCodeList();

        Set<String> roleCodeSet = userRoleList.stream().map(UserRole::getRoleCode).collect(Collectors.toSet());
        Set<String> allowedRoleCodeSet = Arrays.stream(allowedRoleCodeList).collect(Collectors.toSet());
        roleCodeSet.retainAll(allowedRoleCodeSet);   //取交集

        if(roleCodeSet.size() <= 0){
            throw new ConditionException("权限不足");
        }
    }
    
}
