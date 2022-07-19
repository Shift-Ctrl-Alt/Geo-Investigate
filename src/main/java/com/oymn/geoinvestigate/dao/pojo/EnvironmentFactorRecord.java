package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("环境要素表")
public class EnvironmentFactorRecord {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主记录id")
    private Long recordId;

    @ApiModelProperty("土壤湿度")
    private String soilMoisture;   //土壤湿度

    @ApiModelProperty("土壤温度")
    private String soilTemp;       //土壤温度

    @ApiModelProperty("空气湿度")
    private String airMoisture;    //空气湿度

    @ApiModelProperty("空气温度")
    private String airTemp;        //空气温度

    @ApiModelProperty("创建时间")
    private Date createTime;       //创建时间

    @ApiModelProperty("修改时间")
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
