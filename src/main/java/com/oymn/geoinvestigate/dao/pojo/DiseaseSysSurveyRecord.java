package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DiseaseSysSurveyRecord {
    
    private Long id;
    
    private Long recordId;
    
    private String diseaseType;
    
    private Integer surveyLeaves;

    private Integer diseasedLeaves;
    
    private String quadratCanopyImg;
    
    private String quadratLeavesImg;
    
    private Date createTime;
    
    private Date updateTime;

    public DiseaseSysSurveyRecord() {
    }

    public DiseaseSysSurveyRecord(Long id, Long recordId, String diseaseType, Integer surveyLeaves, Integer diseasedLeaves, String quadratCanopyImg, String quadratLeavesImg) {
        this.id = id;
        this.recordId = recordId;
        this.diseaseType = diseaseType;
        this.surveyLeaves = surveyLeaves;
        this.diseasedLeaves = diseasedLeaves;
        this.quadratCanopyImg = quadratCanopyImg;
        this.quadratLeavesImg = quadratLeavesImg;
    }
}
