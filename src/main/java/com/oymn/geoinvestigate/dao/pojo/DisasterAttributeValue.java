package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("灾害属性值类 DisasterAttributeValue")
public class DisasterAttributeValue {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("灾害类型的id")
    private Long disasterId;
    
    @ApiModelProperty("灾害属性的id")
    private Long disasterAttributeId;
    
    @ApiModelProperty("中文名称")
    private String valueChs;
    
    @ApiModelProperty("英文名称")
    private String valueEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisasterId() {
        return disasterId;
    }

    public void setDisasterId(Long disasterId) {
        this.disasterId = disasterId;
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
}
