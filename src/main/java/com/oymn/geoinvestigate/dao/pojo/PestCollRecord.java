package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Date;

@Data
@ApiModel("虫害采集表")
public class PestCollRecord {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主记录id")
    private Long recordId;

    @ApiModelProperty("虫害类型")
    private String pestType;

    @ApiModelProperty("样方冠层图片")
    private String quadratCanopyImg;   //样方冠层图片

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public PestCollRecord() {
    }

    public PestCollRecord(Long id, Long recordId, String pestType, String quadratCanopyImg) {
        this.id = id;
        this.recordId = recordId;
        this.pestType = pestType;
        this.quadratCanopyImg = quadratCanopyImg;
    }
}
