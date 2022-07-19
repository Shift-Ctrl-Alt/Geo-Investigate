package com.oymn.geoinvestigate.dao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EnvironmentFactorRecord {
    
    private Long id;
    
    private Long recordId;
    
    private String soilMoisture;   //土壤湿度
    
    private String soilTemp;       //土壤温度
    
    private String airMoisture;    //空气湿度
    
    private String airTemp;        //空气温度
    
    private Date createTime;       //创建时间
     
    private Date updateTime;       //更新时间

    public EnvironmentFactorRecord() {
    }

    public EnvironmentFactorRecord(Long id, Long recordId, String soilMoisture, String soilTemp, String airMoisture, String airTemp) {
        this.id = id;
        this.recordId = recordId;
        this.soilMoisture = soilMoisture;
        this.soilTemp = soilTemp;
        this.airMoisture = airMoisture;
        this.airTemp = airTemp;
    }
}
