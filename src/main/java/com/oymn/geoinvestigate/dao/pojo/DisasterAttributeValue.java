package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("灾害属性值类 DisasterAttributeValue")
public class DisasterAttributeValue {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("灾害属性的id")
    private Long disasterAttributeId;
    
    @ApiModelProperty("中文名称")
    private String valueChs;
    
    @ApiModelProperty("英文名称")
    private String valueEn;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisasterAttributeId() {
        return disasterAttributeId;
    }

    public void setDisasterAttributeId(Long disasterAttributeId) {
        this.disasterAttributeId = disasterAttributeId;
    }

    public String getValueChs() {
        return valueChs;
    }

    public void setValueChs(String valueChs) {
        this.valueChs = valueChs;
    }

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
