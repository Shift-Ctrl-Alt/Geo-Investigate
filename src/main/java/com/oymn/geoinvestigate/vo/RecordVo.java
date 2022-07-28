package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("用于和前端交互的记录实体类对象")
public class RecordVo {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("所属用户的id")
    private Long userId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度
    
    @ApiModelProperty("经度")
    private Double longitude;  //经度

    @ApiModelProperty("调查时间")
    private Date surveyTime;   //调查时间

    @ApiModelProperty("土地类型信息")
    private String landMsg;    //土地类型信息

    @ApiModelProperty("作物类型")
    private String cropType;   //作物类型

    @ApiModelProperty("作物品种")
    private String cropVariety;  //作物品种

    @ApiModelProperty("样地冠层图片地址")
    private String spCanopyImg;  //样地冠层图片

    @ApiModelProperty("备注信息")
    private String note;   //备注信息

    @ApiModelProperty("病害样本采集表记录")
    private List<DiseaseSamCollRecord> diseaseSamCollRecord;   //病害样本采集表

    @ApiModelProperty("病害系统调查表记录")
    private List<DiseaseSysSurveyRecord> diseaseSysSurveyRecord;  //病害系统调查表

    @ApiModelProperty("机-地病害数据采集表")
    private List<DiseaseDataCollUAVRecord> diseaseDataCollUAVRecord;  //机-地病害数据采集表
    
    @ApiModelProperty("虫害采集表")
    private List<PestCollRecordVo> pestCollRecordVo;
    
    @ApiModelProperty("机-地虫害采集表")
    private List<PestSurveyUAVRecordVo> pestSurveyUAVRecordVo;
    
    @ApiModelProperty("环境要素表")
    private List<EnvironmentFactorRecord> environmentFactorRecord;
    
    @ApiModelProperty("土壤湿度采集表")
    private List<SoilMoistureCollRecordVo> soilMoistureCollRecords;    
    
    @ApiModelProperty("小麦产量采集表")
    private List<WheatYieldCollRecordVo> wheatYieldCollRecords;

    public RecordVo() {
    }

    public RecordVo(Long id, Long userId, Double latitude, Double longitude, Date surveyTime, String landMsg, String cropType, String cropVariety, String spCanopyImg, String note, List<DiseaseSamCollRecord> diseaseSamCollRecord, List<DiseaseSysSurveyRecord> diseaseSysSurveyRecord, List<DiseaseDataCollUAVRecord> diseaseDataCollUAVRecord, List<PestCollRecordVo> pestCollRecordVo, List<PestSurveyUAVRecordVo> pestSurveyUAVRecordVo, List<EnvironmentFactorRecord> environmentFactorRecord, List<SoilMoistureCollRecordVo> soilMoistureCollRecords, List<WheatYieldCollRecordVo> wheatYieldCollRecords) {
        this.id = id;
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.surveyTime = surveyTime;
        this.landMsg = landMsg;
        this.cropType = cropType;
        this.cropVariety = cropVariety;
        this.spCanopyImg = spCanopyImg;
        this.note = note;
        this.diseaseSamCollRecord = diseaseSamCollRecord;
        this.diseaseSysSurveyRecord = diseaseSysSurveyRecord;
        this.diseaseDataCollUAVRecord = diseaseDataCollUAVRecord;
        this.pestCollRecordVo = pestCollRecordVo;
        this.pestSurveyUAVRecordVo = pestSurveyUAVRecordVo;
        this.environmentFactorRecord = environmentFactorRecord;
        this.soilMoistureCollRecords = soilMoistureCollRecords;
        this.wheatYieldCollRecords = wheatYieldCollRecords;
    }

    public void setRecord(Record record){
        this.id = record.getId();
        this.userId = record.getUserId();
        this.latitude = record.getLatitude();
        this.longitude = record.getLongitude();
        this.surveyTime = record.getSurveyTime();
        this.landMsg = record.getLandMsg();
        this.cropType = record.getCropType();
        this.cropVariety = record.getCropVariety();
        this.spCanopyImg = record.getSpCanopyImg();
        this.note = record.getNote();
    }
}
