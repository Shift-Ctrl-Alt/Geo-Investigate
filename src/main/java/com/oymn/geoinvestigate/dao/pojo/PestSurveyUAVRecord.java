package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("机-地虫害调查表")
public class PestSurveyUAVRecord {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主记录的id")
    private Long recordId;

    @ApiModelProperty("虫害类型")
    private String pestType;

    @ApiModelProperty("样方冠层图片")
    private String quadratCanopyImg;   //样方冠层图片

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
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
