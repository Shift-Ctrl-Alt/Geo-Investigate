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

import java.lang.reflect.Method;

@Aspect
@Component
public class CheckUserForDeleteRecordAspect {

    @Autowired
    private UserSupport userSupport;

    @Autowired
    private RecordService recordService;

    @Pointcut("@annotation(com.oymn.geoinvestigate.common.annotation.CheckUserForDeleteRecord)")
    public void check() {

    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        //获取当前登录的用户
        Long currentUserId = userSupport.getCurrentUserId();

        //获取参数值
        Object[] args = joinPoint.getArgs();

        //获取该记录的id
        Object parameterValue = args[0];
        Long recordId = (Long) parameterValue;

        //获取通知的签名
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;

        Object target = joinPoint.getTarget();
        //获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        //获取方法名
        String methodName = method.getName();
        
        //主记录的id
        Long mainRecordId = 0L;
        //TODO: 补充所有表
        switch (methodName){
            case "deleteRecord":
                mainRecordId = recordId;
                break;
            case "deleteDiseaseSamCollRecord":
                DiseaseSamCollRecord diseaseSamCollRecord = recordService.getDiseaseSamCollRecordById(recordId);
                if(diseaseSamCollRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = diseaseSamCollRecord.getRecordId();
                break;
            case "deleteDiseaseSysSurveyRecord":
                DiseaseSysSurveyRecord diseaseSysSurveyRecord = recordService.getDiseaseSysSurveyRecordById(recordId);
                if(diseaseSysSurveyRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = diseaseSysSurveyRecord.getRecordId();
                break;
            case "deleteDiseaseDataCollUAVRecord":
                DiseaseDataCollUAVRecord diseaseDataCollUAVRecord = recordService.getDiseaseDataCollUAVRecordById(recordId);
                if(diseaseDataCollUAVRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = diseaseDataCollUAVRecord.getRecordId();
                break;
            case "deletePestCollRecord":
                PestCollRecord pestCollRecord = recordService.getPestCollRecordById(recordId);
                if(pestCollRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = pestCollRecord.getRecordId();
                break;
            case "deletePestSurveyUAVRecord":
                PestSurveyUAVRecord pestSurveyUAVRecord = recordService.getPestSurveyUAVRecordById(recordId);
                if(pestSurveyUAVRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = pestSurveyUAVRecord.getRecordId();
                break;
            case "deleteEnvironmentFactor":
                EnvironmentFactorRecord environmentFactorRecord = recordService.getEnvironmentFactorRecordById(recordId);
                if(environmentFactorRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = environmentFactorRecord.getRecordId();
                break;
            case "deleteSoilMoistureCollRecord":
                SoilMoistureCollRecord soilMoistureCollRecord = recordService.getSoilMoistureCollRecordById(recordId);
                if(soilMoistureCollRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = soilMoistureCollRecord.getRecordId();
                break;
            case "deleteWheatYieldCollRecord":
                WheatYieldCollRecord wheatYieldCollRecord = recordService.getWheatYieldCollRecordById(recordId);
                if(wheatYieldCollRecord == null){
                    throw new ConditionException("该记录不存在");
                }
                mainRecordId = wheatYieldCollRecord.getRecordId();
                break;
        }

        Record record = recordService.getRecordById(mainRecordId);
        if(record == null){
            throw new ConditionException("该记录不存在");
        }
        Long userId = record.getUserId();

        if(currentUserId != userId){
            throw new ConditionException("记录所有者不是该登录用户");
        }

    }
}
