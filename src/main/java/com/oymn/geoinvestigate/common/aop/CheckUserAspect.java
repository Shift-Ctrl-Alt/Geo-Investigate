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
public class CheckUserAspect {

    @Autowired
    private UserSupport userSupport;

    @Autowired
    private RecordService recordService;

    @Pointcut("@annotation(com.oymn.geoinvestigate.common.annotation.CheckUser)")
    public void check() {

    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        //获取当前登录的用户
        Long currentUserId = userSupport.getCurrentUserId();

        //获取通知的签名
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;

        Object target = joinPoint.getTarget();
        //获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        //获取参数值
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            Object parameterValue = args[i];

            // TODO: 补充所有记录类型
            if (parameterValue instanceof DiseaseSamCollRecord
                    || parameterValue instanceof DiseaseSysSurveyRecord
                    || parameterValue instanceof DiseaseDataCollUAVRecord
                    || parameterValue instanceof PestCollRecord
                    || parameterValue instanceof PestSurveyUAVRecord) {

                //获取recordId这个属性
                Field recordIdField = parameterValue.getClass().getDeclaredField("recordId");
                recordIdField.setAccessible(true);
                //获取recordId的值
                Long recordId = (Long) recordIdField.get(parameterValue);
                //通过recordId的值查询Record主记录
                Record record = recordService.getRecordById(recordId);

                Long userId = record.getUserId();
                if (userId != currentUserId) {
                    throw new ConditionException("记录所有者不是该登录用户");
                }
            } else if (parameterValue instanceof Record) {
                Field userIdField = parameterValue.getClass().getDeclaredField("userId");
                userIdField.setAccessible(true);
                Long userId = (Long) userIdField.get(parameterValue);
                if (userId != currentUserId) {
                    throw new ConditionException("记录所有者不是该登录用户");
                }
            }
        }

    }
}
