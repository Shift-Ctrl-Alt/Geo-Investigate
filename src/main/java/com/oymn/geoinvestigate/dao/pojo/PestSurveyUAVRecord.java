package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PestSurveyUAVRecord {
    
    private Long id;
    
    private Long recordId;
    
    private String pestType;
    
    private String quadratCanopyImg;   //样方冠层图片
    
    private Date createTime;
    
    private Date updateTime;

    public PestSurveyUAVRecord() {
    }

    public PestSurveyUAVRecord(Long id, Long recordId, String pestType, String quadratCanopyImg) {
        this.id = id;
        this.recordId = recordId;
        this.pestType = pestType;
        this.quadratCanopyImg = quadratCanopyImg;
    }
}
