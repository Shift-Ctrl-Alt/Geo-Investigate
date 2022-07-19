package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DiseaseSamCollRecord {
    
    private Long id;
    
    private Long recordId;             //主记录的id
    
    private String diseaseType;        //病害类型
    
    private Integer surveyLeaves;      //调查总叶子数  
    
    private Integer diseasedLeaves;     //病害叶子数
    
    private String quadratCanopyImg;    //样方冠层图片
    
    private String quadratLeavesImg;    //样方叶片图片
    
    private Date createTime;
    
    private Date updateTime;

    public DiseaseSamCollRecord() {
    }

    public DiseaseSamCollRecord(Long id, Long recordId, String diseaseType, Integer surveyLeaves, Integer diseasedLeaves, String quadratCanopyImg, String quadratLeavesImg) {
        this.id = id;
        this.recordId = recordId;
        this.diseaseType = diseaseType;
        this.surveyLeaves = surveyLeaves;
        this.diseasedLeaves = diseasedLeaves;
        this.quadratCanopyImg = quadratCanopyImg;
        this.quadratLeavesImg = quadratLeavesImg;
    }
}
