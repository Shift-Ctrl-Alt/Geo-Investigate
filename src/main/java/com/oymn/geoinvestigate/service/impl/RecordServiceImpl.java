package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.RecordDao;
import com.oymn.geoinvestigate.dao.pojo.*;
import com.oymn.geoinvestigate.service.RecordService;
import com.oymn.geoinvestigate.vo.PestCollRecordVo;
import com.oymn.geoinvestigate.vo.PestSurveyUAVRecordVo;
import com.oymn.geoinvestigate.vo.RecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static javafx.scene.input.KeyCode.L;

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    private RecordDao recordDao;
    
    @Override
    public Long addMainRecord(Record record) {
        recordDao.addMainRecord(record);
        return record.getId();
    }

    @Override
    public void updateMainRecord(Record record) {
        recordDao.updateMainRecord(record);
    }

    @Override
    public Long addDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord) {
        recordDao.addDiseaseSamCollRecord(diseaseSamCollRecord);
        return diseaseSamCollRecord.getId();
    }

    @Override
    public void updateDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord) {
        recordDao.updateDiseaseSamCollRecord(diseaseSamCollRecord);
    }

    @Override
    public Long addDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord) {
        recordDao.addDiseaseSysSurveyRecord(diseaseSysSurveyRecord);
        return diseaseSysSurveyRecord.getId();
    }

    @Override
    public Record getRecordById(Long recordId) {
        return recordDao.getRecordById(recordId);
    }

    @Override
    public void updateDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord) {
        recordDao.updateDiseaseSysSurveyRecord(diseaseSysSurveyRecord);
    }

    @Override
    public Long addDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord) {
        recordDao.addDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);
        return diseaseDataCollUAVRecord.getId();
    }

    @Override
    public void updateDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord) {
        recordDao.updateDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);
    }

    @Override
    public Long addPestCollRecord(PestCollRecord pestCollRecord) {
        recordDao.addPestCollRecord(pestCollRecord);
        return pestCollRecord.getId();
    }

    @Override
    public Long addPestImgRecord(PestImgRecord pestImgRecord) {
        recordDao.addPestImgRecord(pestImgRecord);
        return pestImgRecord.getId();
    }

    @Override
    public void updatePestCollRecord(PestCollRecord pestCollRecord) {
        recordDao.updatePestCollRecord(pestCollRecord);
    }


    @Override
    public Long getUserIdByPestImgRecordId(Long pestImgRecordId) {
        return recordDao.getUserIdByPestImgRecordId(pestImgRecordId);
    }

    @Override
    public void deletePestImgRecordById(Long pestImgRecordId) {
        recordDao.deletePestImgRecordById(pestImgRecordId);
    }

    @Override
    public Long addPestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord) {
        recordDao.addPestSurveyUAVRecord(pestSurveyUAVRecord);
        return pestSurveyUAVRecord.getId();
    }

    @Override
    public void updatePestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord) {
        recordDao.updatePestSurveyUAVRecord(pestSurveyUAVRecord);
    }

    @Override
    public Long addPestUAVImgRecord(PestUAVImgRecord pestUAVImgRecord) {
        recordDao.addPestUAVImgRecord(pestUAVImgRecord);
        return pestUAVImgRecord.getId();
    }

    @Override
    public void deletePestUAVImgRecordById(Long pestUAVImgId) {
        recordDao.deletePestUAVImgRecordById(pestUAVImgId);
    }

    @Override
    public Long getUserIdByPestUAVImgRecordId(Long pestUAVImgRecordId) {
        return recordDao.getUserIdByPestUAVImgRecordId(pestUAVImgRecordId);
    }

    @Override
    public Long addEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord) {
        return recordDao.addEnvironmentFactor(environmentFactorRecord);
    }

    @Override
    public PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize) {
        if(userId == null || pageNo == null || pageSize == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        //封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        //获取本次查询到的真实数据条数
        Integer count = recordDao.getRecordCount(params);
        List<Record> recordList = new ArrayList<>();
        if(count > 0){
            recordList = recordDao.getRecords(params);
        }
        
        return new PageResult<>(count, recordList);
    }



    @Override
    public void deleteRecord(Long currentUserId, Long recordId) {
        Record record = recordDao.getRecordById(recordId);
        if(record == null){
            throw new ConditionException("该记录不存在");
        }

        Long userId = record.getUserId();
        if(currentUserId != userId){
            throw new ConditionException("记录所有者不是该登录用户");
        }
        
        recordDao.deleteRecord(recordId);
    }

    @Override
    public RecordVo getRecordVoById(Long recordId) {
        RecordVo recordVo = new RecordVo();
        Record record = recordDao.getRecordById(recordId);
        if(record == null){
            return recordVo;
        }
        
        recordVo.setRecord(record);
        
        //设置病害样本采集表
        DiseaseSamCollRecord diseaseSamCollRecord = recordDao.getDiseaseSamCollRecordByRecordId(recordId);
        recordVo.setDiseaseSamCollRecord(diseaseSamCollRecord);
        
        //设置病假系统调查表
        DiseaseSysSurveyRecord diseaseSysSurveyRecord = recordDao.getDiseaseSysSurveyRecordByRecordId(recordId);
        recordVo.setDiseaseSysSurveyRecord(diseaseSysSurveyRecord);
        
        //设置机地病害数据采集表
        DiseaseDataCollUAVRecord diseaseDataCollUAVRecord = recordDao.getDiseaseDataCollUAVRecordByRecordId(recordId);
        recordVo.setDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);
        
        //设置虫害采集表
        PestCollRecordVo pestCollRecordVo = new PestCollRecordVo();
        PestCollRecord pestCollRecord = recordDao.getPestCollRecordByRecordId(recordId);
        if(pestCollRecord != null){
            pestCollRecordVo.setPestCollRecord(pestCollRecord);
            List<String> pestLeavesImgs = recordDao.getPestLeavesImgsByPestCollRecordId(pestCollRecord.getId());
            pestCollRecordVo.setPestLeavesImgs(pestLeavesImgs);
        }
        recordVo.setPestCollRecordVo(pestCollRecordVo);
        
        //设置机-地虫害调查表
        PestSurveyUAVRecordVo pestSurveyUAVRecordVo = new PestSurveyUAVRecordVo();
        PestSurveyUAVRecord pestSurveyUAVRecord = recordDao.getPestSurveyUAVRecordByRecordId(recordId);
        if(pestSurveyUAVRecord != null){
            pestSurveyUAVRecordVo.setPestSurveyUAVRecord(pestSurveyUAVRecord);
            List<String> pestLeavesImgs = recordDao.getPestLeavesImgsUAVByPestSurveyRecordId(pestSurveyUAVRecord.getId());
            pestSurveyUAVRecordVo.setPestLeavesImgs(pestLeavesImgs);
        }
        recordVo.setPestSurveyUAVRecordVo(pestSurveyUAVRecordVo);
        
        //设置环境要素
        EnvironmentFactorRecord environmentFactorRecord = recordDao.getEnvirongmentFactorByRecordId(recordId);
        recordVo.setEnvironmentFactorRecord(environmentFactorRecord);
        
        //设置土壤湿度采集表
        // TODO:这里的样方编号需不需要和每个样方对应上
        List<SoilMoistureCollRecord> soilMoistureCollRecords = recordDao.getSoilMoistureCollRecordsByRecordId(recordId);
        recordVo.setSoilMoistureCollRecords(soilMoistureCollRecords);
        
        //设置小麦产量采集表
        List<WheatYieldCollRecord> wheatYieldCollRecords = recordDao.getWheatYieldCollRecordsbyRecordId(recordId);
        recordVo.setWheatYieldCollRecords(wheatYieldCollRecords);
        
        return recordVo;
    }
}
