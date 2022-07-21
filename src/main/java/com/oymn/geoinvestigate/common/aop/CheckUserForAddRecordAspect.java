package com.oymn.geoinvestigate.common.aop;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.pojo.*;
import com.oymn.geoinvestigate.handler.UserSupport;
import com.oymn.geoinvestigate.service.RecordService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
@Component
public class CheckUserForAddRecordAspect {

    @Autowired
    private UserSupport userSupport;

    @Autowired
    private RecordService recordService;

    @Pointcut("@annotation(com.oymn.geoinvestigate.common.annotation.CheckUserForAddRecord)")
    public void check() {

    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        //获取当前登录的用户
        Long currentUserId = userSupport.getCurrentUserId();
        
        //获取参数值
        Object[] args = joinPoint.getArgs();

        //获取主记录的id
        Object parameterValue = args[0];
        Long recordId = (Long) parameterValue;

        Record record = recordService.getRecordById(recordId);
        if(record == null){
            throw new ConditionException("该记录不存在");
        }
        Long userId = record.getUserId();
        
        if(currentUserId != userId){
            throw new ConditionException("记录所有者不是该登录用户");
        }

    }
}
