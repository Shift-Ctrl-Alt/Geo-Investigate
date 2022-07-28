package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("病害样本采集表")
public class DiseaseSamCollRecord {
    
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主记录的id")
    private Long recordId;             //主记录的id

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度

    @ApiModelProperty("病害类型")
    private String diseaseType;        //病害类型

    @ApiModelProperty("调查总叶子数")
    private Integer surveyLeaves;      //调查总叶子数  

    @ApiModelProperty("病害叶子数")
    private Integer diseasedLeaves;     //病害叶子数

    @ApiModelProperty("样方冠层图片")
    private String quadratCanopyImg;    //样方冠层图片

    @ApiModelProperty("样方叶片图片")
    private String quadratLeavesImg;    //样方叶片图片

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
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
