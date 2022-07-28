package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("小麦产量表")
public class WheatYieldCollRecord {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;
    
    @ApiModelProperty("样点的id，前端生成")
    private Long siteId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度
    
    @ApiModelProperty("灾害类型")
    private String disasterType;
    
    @ApiModelProperty("防治措施")
    private String solution;
    
    @ApiModelProperty("麦籽的重量")
    private String wheatSeedWeight;
    
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public WheatYieldCollRecord() {
    }

    public WheatYieldCollRecord(Long id, Long recordId, Long siteId, String disasterType, String solution, String wheatSeedWeight) {
        this.id = id;
        this.recordId = recordId;
        this.siteId = siteId;
        this.disasterType = disasterType;
        this.solution = solution;
        this.wheatSeedWeight = wheatSeedWeight;
    }
}
