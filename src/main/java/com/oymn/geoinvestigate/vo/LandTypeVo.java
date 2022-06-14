package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.LandType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("土地类型类 LandTypeVo，用于和前端交互")
public class LandTypeVo {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("中文名称")
    private String nameChs;

    @ApiModelProperty("英文名称")
    private String nameEn;

    @ApiModelProperty("二级土地类型")
    private List<LandType> subLandType;

    public LandTypeVo() {
    }

    public LandTypeVo(Long id, String nameChs, String nameEn) {
        this.id = id;
        this.nameChs = nameChs;
        this.nameEn = nameEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<LandType> getSubLandType() {
        return subLandType;
    }

    public void setSubLandType(List<LandType> subLandType) {
        this.subLandType = subLandType;
    }
}
