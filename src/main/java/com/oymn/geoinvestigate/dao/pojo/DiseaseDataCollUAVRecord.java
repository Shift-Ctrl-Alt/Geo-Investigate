package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("机-地病害数据采集表")
public class DiseaseDataCollUAVRecord {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度

    @ApiModelProperty("病害类型")
    private String diseaseType;

    @ApiModelProperty("调查的叶片数")
    private Integer surveyLeaves;

    @ApiModelProperty("病叶数")
    private Integer diseasedLeaves;

    @ApiModelProperty("样点冠层图片")
    private String siteCanopyImg;  //样点冠层图片

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
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
