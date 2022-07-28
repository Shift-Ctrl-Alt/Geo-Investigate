package com.oymn.geoinvestigate.common.aop;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.RecordDao;
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

/**
 * 更新记录时检查用户身份
 */
@Aspect
@Component
public class CheckUserForUpdateRecordAspect {

    @Autowired
    private UserSupport userSupport;

    @Autowired
    private RecordService recordService;

    @Pointcut("@annotation(com.oymn.geoinvestigate.common.annotation.CheckUserForUpdateRecord)")
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

        Object parameterValue = args[0];

        //获取id
        Long id;
        Field idField = null;
        try {
            idField = parameterValue.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            id = (Long) idField.get(parameterValue);
        } catch (Exception e) {
            throw new ConditionException("参数有误");
        }

        if (id == null) {
            throw new ConditionException("参数有误");
        }

        Long recordId = null;
        // TODO: 补充所有记录类型
        if (parameterValue instanceof Record) {
            recordId = id;
        } else if (parameterValue instanceof DiseaseSamCollRecord) {
            DiseaseSamCollRecord diseaseSamCollRecord = recordService.getDiseaseSamCollRecordById(id);
            recordId = diseaseSamCollRecord.getRecordId();
        } else if (parameterValue instanceof DiseaseSysSurveyRecord) {
            DiseaseSysSurveyRecord diseaseSysSurveyRecord = recordService.getDiseaseSysSurveyRecordById(id);
            recordId = diseaseSysSurveyRecord.getRecordId();
        } else if (parameterValue instanceof DiseaseDataCollUAVRecord) {
            DiseaseDataCollUAVRecord diseaseDataCollUAVRecord = recordService.getDiseaseDataCollUAVRecordById(id);
            recordId = diseaseDataCollUAVRecord.getRecordId();
        } else if (parameterValue instanceof PestCollRecord) {
            PestCollRecord pestCollRecord = recordService.getPestCollRecordById(id);
            recordId = pestCollRecord.getRecordId();
        } else if (parameterValue instanceof PestSurveyUAVRecord) {
            PestSurveyUAVRecord pestSurveyUAVRecord = recordService.getPestSurveyUAVRecordById(id);
            recordId = pestSurveyUAVRecord.getRecordId();
        } else if (parameterValue instanceof EnvironmentFactorRecord) {
            EnvironmentFactorRecord environmentFactorRecord = recordService.getEnvironmentFactorRecordById(id);
            recordId = environmentFactorRecord.getRecordId();
        } else if (parameterValue instanceof SoilMoistureCollRecord) {
            SoilMoistureCollRecord soilMoistureCollRecord = recordService.getSoilMoistureCollRecordById(id);
            recordId = soilMoistureCollRecord.getRecordId();
        } else if (parameterValue instanceof WheatYieldCollRecord) {
            WheatYieldCollRecord wheatYieldCollRecord = recordService.getWheatYieldCollRecordById(id);
            recordId = wheatYieldCollRecord.getRecordId();
        }

        if (recordId == null) {
            throw new ConditionException("记录有误");
        }

        Record record = recordService.getRecordById(recordId);
        Long userId = record.getUserId();
        if (userId != currentUserId) {
            throw new ConditionException("记录所有者不是该登录用户");
        }
    }
}
