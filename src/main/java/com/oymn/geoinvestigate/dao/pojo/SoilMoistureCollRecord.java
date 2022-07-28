package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("土壤湿度采集表")
public class SoilMoistureCollRecord {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;
    
    @ApiModelProperty("样点的id,前端自动生成")
    private Long siteId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度
    
    @ApiModelProperty("土壤类型")
    private String soilType;
    
    @ApiModelProperty("10cm的土壤湿度")
    private String depth_10;
    
    @ApiModelProperty("20cm的土壤湿度")
    private String depth_20;
    
    @ApiModelProperty("30cm的土壤湿度")
    private String depth_30;
    
    @ApiModelProperty("空气温度")
    private String airTemp;
    
    @ApiModelProperty("空气湿度")
    private String airMoisture;
    
    @ApiModelProperty("创建时间")
    private Date createTime;
    
    @ApiModelProperty("修改时间")
    private Date updateTime;

    public SoilMoistureCollRecord() {
    }

    public SoilMoistureCollRecord(Long id, Long recordId, Long siteId, String soilType, String depth_10, String depth_20, String depth_30, String airTemp, String airMoisture) {
        this.id = id;
        this.recordId = recordId;
        this.siteId = siteId;
        this.soilType = soilType;
        this.depth_10 = depth_10;
        this.depth_20 = depth_20;
        this.depth_30 = depth_30;
        this.airTemp = airTemp;
        this.airMoisture = airMoisture;
    }
}
