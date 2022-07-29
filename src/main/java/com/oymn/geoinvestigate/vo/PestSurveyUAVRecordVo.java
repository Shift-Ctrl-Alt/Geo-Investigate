package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.PestCollRecord;
import com.oymn.geoinvestigate.dao.pojo.PestSurveyUAVRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("机-地虫害调查表Vo")
public class PestSurveyUAVRecordVo {
    
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("主记录的id")
    private Long recordId;

    @ApiModelProperty("纬度")
    private Double latitude;   //纬度

    @ApiModelProperty("经度")
    private Double longitude;  //经度
    
    @ApiModelProperty("虫害类型")
    private String pestType;
    
    @ApiModelProperty("样方冠层图片地址")
    private String quadratCanopyImg;
    
    @ApiModelProperty("十张虫害叶片照片地址")
    private List<String> pestLeavesImgs;

    public PestSurveyUAVRecordVo() {
    }

    public PestSurveyUAVRecordVo(Long id, Long recordId, String pestType, String quadratCanopyImg, List<String> pestLeavesImgs) {
        this.id = id;
        this.recordId = recordId;
        this.pestType = pestType;
        this.quadratCanopyImg = quadratCanopyImg;
        this.pestLeavesImgs = pestLeavesImgs;
    }
    
    public void setPestSurveyUAVRecord(PestSurveyUAVRecord pestSurveyUAVRecord){
        this.id = pestSurveyUAVRecord.getId();
        this.recordId = pestSurveyUAVRecord.getRecordId();
        this.latitude = pestSurveyUAVRecord.getLatitude();
        this.longitude = pestSurveyUAVRecord.getLongitude();
        this.pestType = pestSurveyUAVRecord.getPestType();
        this.quadratCanopyImg = pestSurveyUAVRecord.getQuadratCanopyImg();
    }
}
