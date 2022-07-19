package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DiseaseDataCollUAVRecord {
    
    private Long id;
    
    private Long recordId;
    
    private String diseaseType;
    
    private Integer surveyLeaves;
    
    private Integer diseasedLeaves;
    
    private String siteCanopyImg;  //样点冠层图片
    
    private Date createTime;
    
    private Date updateTime;

    public DiseaseDataCollUAVRecord() {
    }

    public DiseaseDataCollUAVRecord(Long id, Long recordId, String diseaseType, Integer surveyLeaves, Integer diseasedLeaves, String siteCanopyImg) {
        this.id = id;
        this.recordId = recordId;
        this.diseaseType = diseaseType;
        this.surveyLeaves = surveyLeaves;
        this.diseasedLeaves = diseasedLeaves;
        this.siteCanopyImg = siteCanopyImg;
    }
}
