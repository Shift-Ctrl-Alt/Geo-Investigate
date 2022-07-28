package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.*;
import com.oymn.geoinvestigate.vo.RecordVo;

public interface RecordService {

    /**
     * 添加记录
     * @param record
     */
    Long addMainRecord(Record record);

    /**
     * 更新记录
     * @param record
     */
    void updateMainRecord(Record record);

    /**
     * 分页查找记录
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize);
    
    /**
     * 删除记录
     * @param recordId
     */
    void deleteRecord(Long recordId);

    /**
     * 添加一条病害样本采集记录
     * @param diseaseSamCollRecord
     * @return
     */
    Long addDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord);

    /**
     * 更新病害样例采集表记录
     * @param diseaseSamCollRecord
     */
    void updateDiseaseSamCollRecord(DiseaseSamCollRecord diseaseSamCollRecord);

    /**
     * 添加病害系统调查表记录
     * @param diseaseSysSurveyRecord
     * @return
     */
    Long addDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord);

    /**
     * 通过主键id获取Record记录实体
     * @param recordId
     * @return
     */
    Record getRecordById(Long recordId);

    /**
     * 更新病害系统调查表
     * @param diseaseSysSurveyRecord
     */
    void updateDiseaseSysSurveyRecord(DiseaseSysSurveyRecord diseaseSysSurveyRecord);

    /**
     * 添加机-地病害数据采集表记录
     * @param diseaseDataCollUAVRecord
     * @return
     */
    Long addDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord);

    /**
     * 更新机-地病害数据采集表记录
     * @param diseaseDataCollUAVRecord
     */
    void updateDiseaseDataCollUAVRecord(DiseaseDataCollUAVRecord diseaseDataCollUAVRecord);

    /**
     * 添加虫害采集表记录
     * @param pestCollRecord
     * @return
     */
    Long addPestCollRecord(PestCollRecord pestCollRecord);

    /**
     * 添加虫害叶片照片表记录
     * @param pestImgRecord
     * @return
     */
    Long addPestImgRecord(PestImgRecord pestImgRecord);

    /**
     * 更新虫害叶片采集表记录
     * @param pestCollRecord
     */
    void updatePestCollRecord(PestCollRecord pestCollRecord);

    /**
     * 通过
     * @return
     */
    Long getUserIdByPestImgRecordId(Long pestImgRecordId);

    /**
     * 删除虫害叶片照片表的记录
     * @param pestImgRecordId
     */
    void deletePestImgRecordById(Long pestImgRecordId);

    /**
     * 添加机-地虫害调查调查表记录
     * @param pestSurveyUAVRecord
     * @return
     */
    Long addPestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord);

    /**
     * 更新机-地虫害调查表记录
     * @param pestSurveyUAVRecord
     */
    void updatePestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord);

    /**
     * 添加机-地虫害叶片照片表记录
     * @param pestUAVImgRecord
     * @return
     */
    Long addPestUAVImgRecord(PestUAVImgRecord pestUAVImgRecord);

    /**
     * 删除机-地虫害叶片照片表记录
     * @param pestUAVImgId
     */
    void deletePestUAVImgRecordById(Long pestUAVImgId);

    Long getUserIdByPestUAVImgRecordId(Long pestUAVImgRecordId);

    /**
     * 添加环境要素表记录
     * @param environmentFactorRecord
     * @return
     */
    Long addEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord);

    /**
     * 根据id获取RecordVo
     * @param recordId
     * @return
     */
    RecordVo getRecordVoById(Long recordId);

    /**
     * 根据id获取灾害样本采集表记录
     * @param id
     * @return
     */
    DiseaseSamCollRecord getDiseaseSamCollRecordById(Long id);

    /**
     * 根据id获取灾害系统调查表记录
     * @param id
     * @return
     */
    DiseaseSysSurveyRecord getDiseaseSysSurveyRecordById(Long id);

    /**
     * 根据id获取机-地灾害数据采集表几楼
     * @param id
     * @return
     */
    DiseaseDataCollUAVRecord getDiseaseDataCollUAVRecordById(Long id);

    /**
     * 根据id获取虫害采集表记录
     * @param id
     * @return
     */
    PestCollRecord getPestCollRecordById(Long id);

    /**
     * 根据id获取机-地虫害调查表记录
     * @param id
     * @return
     */
    PestSurveyUAVRecord getPestSurveyUAVRecordById(Long id);

    /**
     * 更新环境要素实体类
     * @param environmentFactorRecord
     */
    void updateEnvironmentFactor(EnvironmentFactorRecord environmentFactorRecord);

    /**
     * 根据id查询环境要素
     * @param id
     * @return
     */
    EnvironmentFactorRecord getEnvironmentFactorRecordById(Long id);

    /**
     * 根据id删除灾害样本采集表记录
     * @param id
     */
    void deleteDiseaseSamCollRecordById(Long id);

    /**
     * 根据id删除病害系统调查表记录
     * @param id
     */
    void deleteDiseaseSysSurveyRecordById(Long id);

    /**
     * 根据id删除机-地病害数据采集表
     * @param id
     */
    void deleteDiseaseDataCollUAVRecordById(Long id);

    /**
     * 根据id删除虫害采集表记录
     * @param id
     */
    void deletePestCollRecordById(Long id);

    /**
     * 根据id删除机-地虫害调查表
     * @param id
     */
    void deletePestSurveyUAVRecordById(Long id);

    /**
     * 根据id删除环境因素
     * @param id
     */
    void deleteEnvironmentFactorById(Long id);

    /**
     * 添加土壤湿度采集表记录
     * @param soilMoistureCollRecord
     * @return
     */
    Long addSoilMoistureCollRecord(SoilMoistureCollRecord soilMoistureCollRecord);

    /**
     * 更新土壤湿度采集表记录
     * @param soilMoistureCollRecord
     */
    void updateSoilMoistureCollRecord(SoilMoistureCollRecord soilMoistureCollRecord);

    /**
     * 通过id删除土壤湿度采集表
     * @param id
     */
    void deleteSoilMoistureCollRecordById(Long id);

    /**
     * 根据主记录id删除所有相关的虫害采集表记录
     * @param recordId
     */
    void deletePestCollRecordByRecordId(Long recordId);

    /**
     * 根据主记录id删除所有相关的机-地虫害调查表记录
     */
    void deletePestSurveyUAVRecordByRecordId(Long recordId);

    /**
     * 根据id查询土壤湿度采集表记录
     * @param id
     * @return
     */
    SoilMoistureCollRecord getSoilMoistureCollRecordById(Long id);

    /**
     * 添加一条小麦产量表记录
     * @param wheatYieldCollRecord
     * @return
     */
    Long addWheatYieldCollRecord(WheatYieldCollRecord wheatYieldCollRecord);

    /**
     * 更新小麦产量采集表记录
     * @param wheatYieldCollRecord
     */
    void updateWheatYieldCollRecord(WheatYieldCollRecord wheatYieldCollRecord);

    /**
     * 根据id删除小麦产量采集表记录
     * @param id
     */
    void deleteWheatYieldCollRecordById(Long id);

    /**
     * 查询小麦常量记录
     * @param recordId
     * @return
     */
    WheatYieldCollRecord getWheatYieldCollRecordById(Long id);
}
