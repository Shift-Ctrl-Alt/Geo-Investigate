package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("土地属性值类 LandAttributeValue")
public class LandAttributeValue {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("土地属性的id")
    private Integer landAttributeId;

    @ApiModelProperty("中文名称")
    private String valueChs;

    @ApiModelProperty("英文名称")
    private String valueEn;
    
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLandAttributeId() {
        return landAttributeId;
    }

    public void setLandAttributeId(Integer landAttributeId) {
        this.landAttributeId = landAttributeId;
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
