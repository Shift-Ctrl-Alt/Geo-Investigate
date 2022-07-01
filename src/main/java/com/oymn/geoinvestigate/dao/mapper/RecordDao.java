package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordDao {
    
    void addRecord(Record record);

    int getRecordCount(Map<String, Object> params);

    List<Record> getRecords(Map<String, Object> params);
    
}
