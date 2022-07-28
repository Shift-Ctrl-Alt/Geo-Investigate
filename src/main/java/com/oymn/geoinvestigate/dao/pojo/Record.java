package com.oymn.geoinvestigate.dao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel("记录实体类")
public class Record {
    
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度

    @ApiModelProperty("调查时间,格式：yyyy-MM-dd HH:mm:ss")
    private Date surveyTime;   //调查时间

    @ApiModelProperty("土地类型信息")
    private String landMsg;    //土地类型信息

    @ApiModelProperty("作物类型")
    private String cropType;   //作物类型

    @ApiModelProperty("作物品种")
    private String cropVariety;  //作物品种

    @ApiModelProperty("样地冠层图片")
    private String spCanopyImg;  //样地冠层图片

    @ApiModelProperty("备注信息")
    private String note;   //备注信息

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
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
