package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("对灾害的属性的值进行封装 DisasterAttributeValueVo，用于和前端交互")
public class DisasterAttributeValueVo {

    @ApiModelProperty("灾害类型的id")
    private Long disasterTypeId;
    
    @ApiModelProperty("灾害属性的id")
    private Long disasterAttrId;
    
    @ApiModelProperty("灾害属性的中文名称")
    private String nameChs;
    
    @ApiModelProperty("灾害属性的英文名称")
    private String nameEn;

    @ApiModelProperty("灾害属性的单位")
    private String unit;

    @ApiModelProperty("该属性是否是必需")
    private Integer required;

    @ApiModelProperty("该属性的所有属性值")
    private List<DisasterAttributeValue> attrValues;

    public DisasterAttributeValueVo() {
    }

    public DisasterAttributeValueVo(Long disasterTypeId, Long disasterAttrId, String nameChs, String nameEn, String unit, Integer required) {
        this.disasterTypeId = disasterTypeId;
        this.disasterAttrId = disasterAttrId;
        this.nameChs = nameChs;
        this.nameEn = nameEn;
        this.unit = unit;
        this.required = required;
    }

    public Long getDisasterTypeId() {
        return disasterTypeId;
    }

    public void setDisasterTypeId(Long disasterTypeId) {
        this.disasterTypeId = disasterTypeId;
    }

    public Long getDisasterAttrId() {
        return disasterAttrId;
    }

    public void setDisasterAttrId(Long disasterAttrId) {
        this.disasterAttrId = disasterAttrId;
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

    public List<DisasterAttributeValue> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<DisasterAttributeValue> attrValues) {
        this.attrValues = attrValues;
    }
}
