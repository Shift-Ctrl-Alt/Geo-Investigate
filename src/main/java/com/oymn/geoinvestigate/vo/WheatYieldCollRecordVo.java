package com.oymn.geoinvestigate.vo;

import com.oymn.geoinvestigate.dao.pojo.WheatYieldCollRecord;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("小麦产量表")
public class WheatYieldCollRecordVo {
    
    List<WheatYieldCollRecord> wheatYieldCollRecords;
}
