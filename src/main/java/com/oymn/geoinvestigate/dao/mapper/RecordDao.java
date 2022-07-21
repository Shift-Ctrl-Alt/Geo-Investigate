package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordDao {
    
    void addMainRecord(Record record);

    Integer getRecordCount(Map<String, Object> params);

    List<Record> getRecords(Map<String, Object> params);

    void updateMainRecord(Record record);

    void deleteRecord( Long recordId);

    Record getRecordById(Long recordId);

    void addDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord);

    void updateDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord);

    void addDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord);

    void updateDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord);


    void addDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord);

    void updateDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord);

    void addPestCollRecord(PestCollRecord pestCollRecord);

    void addPestImgRecord(PestImgRecord pestImgRecord);

    void updatePestCollRecord(PestCollRecord pestCollRecord);

    Long getUserIdByPestImgRecordId(Long pestImgRecordId);

    void deletePestImgRecordById(Long pestImgRecordId);

    void addPestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord);

    void updatePestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord);

    void addPestUAVImgRecord(PestUAVImgRecord pestUAVImgRecord);

    void deletePestUAVImgRecordById(Long pestUAVImgId);

    Long getUserIdByPestUAVImgRecordId(Long pestUAVImgRecordId);

    Long addEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord);

    DiseaseSamCollRecord getDiseaseSamCollRecordByRecordId(Long recordId);

    DiseaseSysSurveyRecord getDiseaseSysSurveyRecordByRecordId(Long recordId);

    DiseaseDataCollUAVRecord getDiseaseDataCollUAVRecordByRecordId(Long recordId);

    PestCollRecord getPestCollRecordByRecordId(Long recordId);

    List<String> getPestLeavesImgsByPestCollRecordId(Long pestCollRecordId);

    PestSurveyUAVRecord getPestSurveyUAVRecordByRecordId(Long recordId);

    List<String> getPestLeavesImgsUAVByPestSurveyRecordId(Long pestSurveyUAVRecordId);

    EnvironmentFactorRecord getEnvirongmentFactorByRecordId(Long recordId);

    List<SoilMoistureCollRecord> getSoilMoistureCollRecordsByRecordId(Long recordId);

    List<WheatYieldCollRecord> getWheatYieldCollRecordsbyRecordId(Long recordId);

    DiseaseSamCollRecord getDiseaseSamCollRecordById(Long id);

    DiseaseSysSurveyRecord getDiseaseSysSurveyRecordById(Long id);

    DiseaseDataCollUAVRecord getDiseaseDataCollUAVRecordById(Long id);

    PestCollRecord getPestCollRecordById(Long id);

    PestSurveyUAVRecord getPestSurveyUAVRecordById(Long id);

    void updateEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord);

    EnvironmentFactorRecord getEnvironmentFactorRecordById(Long id);
}
