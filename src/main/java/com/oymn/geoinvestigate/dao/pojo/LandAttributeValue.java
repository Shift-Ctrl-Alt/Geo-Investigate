package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("土地属性值类 LandAttributeValue")
public class LandAttributeValue {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("土地类型的id")
    private Integer landTypeId;

    @ApiModelProperty("土地属性的id")
    private Integer landAttributeId;

    @ApiModelProperty("中文名称")
    private String valueChs;

    @ApiModelProperty("英文名称")
    private String valueEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLandTypeId() {
        return landTypeId;
    }

    public void setLandTypeId(Integer landTypeId) {
        this.landTypeId = landTypeId;
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
}
