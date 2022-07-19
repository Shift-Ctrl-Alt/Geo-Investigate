package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PestUAVImgRecord {
    
    private Long id;
    
    private Long pestSurveyUAVRecordId;
    
    private String img;
    
    private Date createTime;
    
    private Date updateTime;

    public PestUAVImgRecord() {
    }

    public PestUAVImgRecord(Long id, Long pestSurveyUAVRecordId, String img) {
        this.id = id;
        this.pestSurveyUAVRecordId = pestSurveyUAVRecordId;
        this.img = img;
    }
}
