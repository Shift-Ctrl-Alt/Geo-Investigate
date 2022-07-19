package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("病害系统调查表")
public class DiseaseSysSurveyRecord {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;

    @ApiModelProperty("病害类型")
    private String diseaseType;

    @ApiModelProperty("调查叶子数")
    private Integer surveyLeaves;

    @ApiModelProperty("病害叶子数")
    private Integer diseasedLeaves;

    @ApiModelProperty("样方冠层图片")
    private String quadratCanopyImg;

    @ApiModelProperty("样方叶片图片")
    private String quadratLeavesImg;

    @ApiModelProperty("创建时间")
    private Date createTime;
    
    @ApiModelProperty("修改时间")
    private Date updateTime;

    public DiseaseSysSurveyRecord() {
    }

    public DiseaseSysSurveyRecord(Long id, Long recordId, String diseaseType, Integer surveyLeaves, Integer diseasedLeaves, String quadratCanopyImg, String quadratLeavesImg) {
        this.id = id;
        this.recordId = recordId;
        this.diseaseType = diseaseType;
        this.surveyLeaves = surveyLeaves;
        this.diseasedLeaves = diseasedLeaves;
        this.quadratCanopyImg = quadratCanopyImg;
        this.quadratLeavesImg = quadratLeavesImg;
    }
}
