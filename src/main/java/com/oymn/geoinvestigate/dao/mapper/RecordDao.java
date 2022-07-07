package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordDao {
    
    void addRecord(Record record);

    Integer getRecordCount(Map<String, Object> params);

    List<Record> getRecords(Map<String, Object> params);

    void updateRecord(Record record);

    void deleteRecord( Long recordId);

    Record getRecordById(Long recordId);
}
