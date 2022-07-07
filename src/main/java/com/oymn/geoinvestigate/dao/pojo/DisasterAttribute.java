package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("灾害属性类 DisasterAttribute")
public class DisasterAttribute {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("灾害类型id")
    private Long disasterTypeId;
    
    @ApiModelProperty("中文名称")
    private String nameChs;
    
    @ApiModelProperty("英文名称")
    private String nameEn;
    
    @ApiModelProperty("单位")
    private String unit;
    
    @ApiModelProperty("该属性是否必需，1表示是，0表示否")
    private Integer required;
    
    @ApiModelProperty("创建时间")
    private Date createTime;
    
    @ApiModelProperty("最新修改的时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisasterTypeId() {
        return disasterTypeId;
    }

    public void setDisasterTypeId(Long disasterTypeId) {
        this.disasterTypeId = disasterTypeId;
    }

    public String getNameChs() {
        return nameChs;
    }

    public void setNameChs(String nameChs) {
        this.nameChs = nameChs;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
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
