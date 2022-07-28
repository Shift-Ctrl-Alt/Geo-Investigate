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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.*;
import java.util.stream.Collectors;

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
        recordDao.addEnvironmentFactor(environmentFactorRecord);
        return environmentFactorRecord.getId();
    }

    @Override
    public void updateEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord) {
        recordDao.updateEnvironmentFactor(environmentFactorRecord);
    }

    @Override
    public EnvironmentFactorRecord getEnvironmentFactorRecordById(Long id) {
        return recordDao.getEnvironmentFactorRecordById(id);
    }

    @Override
    public PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize) {
        if (userId == null || pageNo == null || pageSize == null) {
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
        if (count > 0) {
            recordList = recordDao.getRecords(params);
        }

        return new PageResult<>(count, recordList);
    }

    @Override
    public DiseaseSamCollRecord getDiseaseSamCollRecordById(Long id) {
        return recordDao.getDiseaseSamCollRecordById(id);
    }

    @Override
    public DiseaseSysSurveyRecord getDiseaseSysSurveyRecordById(Long id) {
        return recordDao.getDiseaseSysSurveyRecordById(id);
    }

    @Override
    public DiseaseDataCollUAVRecord getDiseaseDataCollUAVRecordById(Long id) {
        return recordDao.getDiseaseDataCollUAVRecordById(id);
    }

    @Override
    public PestCollRecord getPestCollRecordById(Long id) {
        return recordDao.getPestCollRecordById(id);
    }

    @Override
    public PestSurveyUAVRecord getPestSurveyUAVRecordById(Long id) {
        return recordDao.getPestSurveyUAVRecordById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRecord(Long recordId) {
        Record record = recordDao.getRecordById(recordId);
        if (record == null) {
            throw new ConditionException("该记录不存在");
        }

        //TODO:删除和该主记录相关的子表
        //删除相关的灾害样本采集表记录
        recordDao.deleteDiseaseSamCollRecordByRecordId(recordId);
        //删除灾害系统调查表
        recordDao.deleteDiseaseSysSurveyRecordByRecordId(recordId);
        //删除机-地灾害数据采集表
        recordDao.deleteDiseaseDataCollUAVRecordByRecordId(recordId);

        //删除虫害采集表记录
        deletePestCollRecordByRecordId(recordId);
        //删除机-地虫害调查表记录
        deletePestSurveyUAVRecordByRecordId(recordId);

        //删除环境因素表
        recordDao.deleteEnvironmentFactorByRecordId(recordId);
        //删除土壤湿度采集表
        recordDao.deleteSoilMoistureCollRecordByRecordId(recordId);
        //删除小麦产量采集表
        recordDao.deleteWheatYieldCollRecordByRecordId(recordId);

        //删除主记录
        recordDao.deleteRecord(recordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePestSurveyUAVRecordByRecordId(Long recordId) {
        recordDao.deletePestSurveyUAVRecordByRecordId(recordId);

        //删除相关的图片
        List<PestSurveyUAVRecord> pestSurveyUAVRecordList = recordDao.getPestSurveyUAVRecordByRecordId(recordId);
        for (PestSurveyUAVRecord pestSurveyUAVRecord : pestSurveyUAVRecordList) {
            Long id = pestSurveyUAVRecord.getId();
            recordDao.deletePestUAVImgRecordByPestSurveyUAVRecordId(id);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePestCollRecordByRecordId(Long recordId) {
        recordDao.deletePestCollRecordByRecordId(recordId);

        //删除相关的图片
        List<PestCollRecord> pestCollRecordList = recordDao.getPestCollRecordByRecordId(recordId);
        for (PestCollRecord pestCollRecord : pestCollRecordList) {
            Long id = pestCollRecord.getId();
            recordDao.deletePestImgRecordByPestCollRecordId(id);
        }
    }


    @Override
    public RecordVo getRecordVoById(Long recordId) {
        RecordVo recordVo = new RecordVo();
        Record record = recordDao.getRecordById(recordId);
        if (record == null) {
            return recordVo;
        }

        recordVo.setRecord(record);

        //设置病害样本采集表
        List<DiseaseSamCollRecord> diseaseSamCollRecord = recordDao.getDiseaseSamCollRecordByRecordId(recordId);
        recordVo.setDiseaseSamCollRecord(diseaseSamCollRecord);

        //设置病假系统调查表
        List<DiseaseSysSurveyRecord> diseaseSysSurveyRecord = recordDao.getDiseaseSysSurveyRecordByRecordId(recordId);
        recordVo.setDiseaseSysSurveyRecord(diseaseSysSurveyRecord);

        //设置机地病害数据采集表
        List<DiseaseDataCollUAVRecord> diseaseDataCollUAVRecord = recordDao.getDiseaseDataCollUAVRecordByRecordId(recordId);
        recordVo.setDiseaseDataCollUAVRecord(diseaseDataCollUAVRecord);

        //设置虫害采集表
        List<PestCollRecord> pestCollRecords = recordDao.getPestCollRecordByRecordId(recordId);
        List<PestCollRecordVo> pestCollRecordVoList = new ArrayList<>();
        for (PestCollRecord pestCollRecord : pestCollRecords) {
            PestCollRecordVo pestCollRecordVo = new PestCollRecordVo();
            pestCollRecordVo.setPestCollRecord(pestCollRecord);
            List<String> pestLeavesImgs = recordDao.getPestLeavesImgsByPestCollRecordId(pestCollRecord.getId());
            pestCollRecordVo.setPestLeavesImgs(pestLeavesImgs);

            pestCollRecordVoList.add(pestCollRecordVo);
        }

        recordVo.setPestCollRecordVo(pestCollRecordVoList);

        //设置机-地虫害调查表
        List<PestSurveyUAVRecord> pestSurveyUAVRecords = recordDao.getPestSurveyUAVRecordByRecordId(recordId);
        List<PestSurveyUAVRecordVo> pestSurveyUAVRecordVoList = new ArrayList<>();
        for (PestSurveyUAVRecord pestSurveyUAVRecord : pestSurveyUAVRecords) {
            PestSurveyUAVRecordVo pestSurveyUAVRecordVo = new PestSurveyUAVRecordVo();
            pestSurveyUAVRecordVo.setPestSurveyUAVRecord(pestSurveyUAVRecord);
            
            List<String> pestLeavesImgs = recordDao.getPestLeavesImgsUAVByPestSurveyRecordId(pestSurveyUAVRecord.getId());
            pestSurveyUAVRecordVo.setPestLeavesImgs(pestLeavesImgs);

            pestSurveyUAVRecordVoList.add(pestSurveyUAVRecordVo);
        }

        recordVo.setPestSurveyUAVRecordVo(pestSurveyUAVRecordVoList);

        //设置环境要素
        List<EnvironmentFactorRecord> environmentFactorRecord = recordDao.getEnvirongmentFactorByRecordId(recordId);
        recordVo.setEnvironmentFactorRecord(environmentFactorRecord);

        //设置土壤湿度采集表
        // TODO:这里的样方编号需不需要和每个样方对应上(待做)
        List<SoilMoistureCollRecord> soilMoistureCollRecords = recordDao.getSoilMoistureCollRecordsByRecordId(recordId);
        Map<Long, List<SoilMoistureCollRecord>> soilMoistureCollRecordsMap = soilMoistureCollRecords.stream().collect(Collectors.groupingBy(SoilMoistureCollRecord::getSiteId));
        recordVo.setSoilMoistureCollRecords(soilMoistureCollRecordsMap);

        //设置小麦产量采集表
        List<WheatYieldCollRecord> wheatYieldCollRecords = recordDao.getWheatYieldCollRecordsbyRecordId(recordId);
        Map<Long, List<WheatYieldCollRecord>> wheatYieldCollRecordsMap = wheatYieldCollRecords.stream().collect(Collectors.groupingBy(WheatYieldCollRecord::getSiteId));
        recordVo.setWheatYieldCollRecords(wheatYieldCollRecordsMap);

        return recordVo;
    }

    @Override
    public void deleteDiseaseSamCollRecordById(Long id) {
        recordDao.deleteDiseaseSamCollRecordById(id);
    }

    @Override
    public void deleteDiseaseSysSurveyRecordById(Long id) {
        recordDao.deleteDiseaseSysSurveyRecordById(id);
    }

    @Override
    public void deleteDiseaseDataCollUAVRecordById(Long id) {
        recordDao.deleteDiseaseDataCollUAVRecordById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePestCollRecordById(Long id) {
        recordDao.deletePestCollRecordById(id);
        //删除相关的图片
        recordDao.deletePestImgRecordByPestCollRecordId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePestSurveyUAVRecordById(Long id) {
        recordDao.deletePestSurveyUAVRecordById(id);
        //删除相关的图片
        recordDao.deletePestUAVImgRecordByPestSurveyUAVRecordId(id);
    }

    @Override
    public void deleteEnvironmentFactorById(Long id) {
        recordDao.deleteEnvironmentFactorById(id);
    }

    @Override
    public Long addSoilMoistureCollRecord(SoilMoistureCollRecord soilMoistureCollRecord) {
        recordDao.addSoilMoistureCollRecord(soilMoistureCollRecord);
        return soilMoistureCollRecord.getId();
    }

    @Override
    public void updateSoilMoistureCollRecord(SoilMoistureCollRecord soilMoistureCollRecord) {
        recordDao.updateSoilMoistureCollRecord(soilMoistureCollRecord);
    }

    @Override
    public void deleteSoilMoistureCollRecordById(Long id) {
        recordDao.deleteSoilMoistureCollRecordById(id);
    }

    @Override
    public SoilMoistureCollRecord getSoilMoistureCollRecordById(Long id) {
        return recordDao.getSoilMoistureCollRecordById(id);
    }

    @Override
    public Long addWheatYieldCollRecord(WheatYieldCollRecord wheatYieldCollRecord) {
        recordDao.addWheatYieldCollRecord(wheatYieldCollRecord);
        return wheatYieldCollRecord.getId();
    }

    @Override
    public void updateWheatYieldCollRecord(WheatYieldCollRecord wheatYieldCollRecord) {
        recordDao.updateWheatYieldCollRecord(wheatYieldCollRecord);
    }

    @Override
    public void deleteWheatYieldCollRecordById(Long id) {
        recordDao.deleteWheatYieldCollRecordById(id);
    }

    @Override
    public WheatYieldCollRecord getWheatYieldCollRecordById(Long id) {
        return recordDao.getWheatYieldCollRecordById(id);
    }
}
