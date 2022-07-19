package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PestImgRecord {
    
    private Long id;
    
    private Long pestCollRecordId;    //虫害采集表中对应记录的id
    
    private String img;
    
    private Date createTime;
    
    private Date updateTime;


    public PestImgRecord() {
    }

    public PestImgRecord(Long id, Long pestCollRecordId, String img) {
        this.id = id;
        this.pestCollRecordId = pestCollRecordId;
        this.img = img;
    }
}
