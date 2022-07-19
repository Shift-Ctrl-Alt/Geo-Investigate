package com.oymn.geoinvestigate.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Record {
    
    private Long id;
    
    private Long userId;

    private Double latitude;   //纬度

    private Double longitude;  //经度
    
    private Date surveyTime;   //调查时间
     
    private String landMsg;    //土地类型信息
    
    private String cropType;   //作物类型
    
    private String cropVariety;  //作物品种
    
    private String spCanopyImg;  //样地冠层图片
    
    private String note;   //备注信息
    
    private Date createTime;
    
    private Date updateTime;

    public Record() {
    }

    public Record(Long id, Long userId, Double latitude, Double longitude, Date surveyTime, String landMsg, String cropType, String cropVariety, String spCanopyImg, String note) {
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
    }
}
