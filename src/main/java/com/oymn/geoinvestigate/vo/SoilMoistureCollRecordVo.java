package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.SoilMoistureCollRecord;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("一个样点的土壤湿度采集表,包含多个样方")
public class SoilMoistureCollRecordVo {
    
    List<SoilMoistureCollRecord> soilMoistureCollRecords;
}
