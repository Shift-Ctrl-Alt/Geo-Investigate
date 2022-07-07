package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("对土地的属性值进行封装 LandAttributeValueVo，用于和前端交互")
public class LandAttributeValueVo {

    @ApiModelProperty("土地类型的id")
    private Long landTypeId;

    @ApiModelProperty("土地属性的id")
    private Long landAttrId;

    @ApiModelProperty("土地属性的中文名称")
    private String nameChs;

    @ApiModelProperty("土地属性的英文名称")
    private String nameEn;

    @ApiModelProperty("土地属性的单位")
    private String unit;

    @ApiModelProperty("该属性是否是必需")
    private Integer required;

    @ApiModelProperty("该属性的所有属性值")
    private List<LandAttributeValue> attributeValues;

    public LandAttributeValueVo() {
    }

    public LandAttributeValueVo(Long landTypeId, Long landAttrId, String nameChs, String nameEn, String unit, Integer required) {
        this.landTypeId = landTypeId;
        this.landAttrId = landAttrId;
        this.nameChs = nameChs;
        this.nameEn = nameEn;
        this.unit = unit;
        this.required = required;
    }

    public Long getLandTypeId() {
        return landTypeId;
    }

    public void setLandTypeId(Long landTypeId) {
        this.landTypeId = landTypeId;
    }

    public Long getLandAttrId() {
        return landAttrId;
    }

    public void setLandAttrId(Long landAttrId) {
        this.landAttrId = landAttrId;
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

    public List<LandAttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<LandAttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
