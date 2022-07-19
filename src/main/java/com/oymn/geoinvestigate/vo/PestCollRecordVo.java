package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.PestCollRecord;
import com.oymn.geoinvestigate.dao.pojo.PestImgRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("虫害采集表Vo，用于与前端交互")
public class PestCollRecordVo {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;
    
    @ApiModelProperty("虫害类型")
    private String pestType;
    
    @ApiModelProperty("样方冠层图片地址")
    private String quadratCanopyImg;
    
    @ApiModelProperty("十张虫害叶片照片表")
    private List<String> pestLeavesImgs;

    public PestCollRecordVo() {
    }

    public PestCollRecordVo(Long id, Long recordId, String pestType, String quadratCanopyImg, List<String> pestLeavesImgs) {
        this.id = id;
        this.recordId = recordId;
        this.pestType = pestType;
        this.quadratCanopyImg = quadratCanopyImg;
        this.pestLeavesImgs = pestLeavesImgs;
    }
    
    public void setPestCollRecord(PestCollRecord pestCollRecord){
        this.id = pestCollRecord.getId();
        this.recordId = pestCollRecord.getRecordId();
        this.pestType = pestCollRecord.getPestType();
        this.quadratCanopyImg = pestCollRecord.getQuadratCanopyImg();
    }
}
