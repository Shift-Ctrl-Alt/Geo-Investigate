package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.PageResult;
import com.oymn.geoinvestigate.dao.pojo.Record;

public interface RecordService {

    /**
     * 添加记录
     * @param record
     */
    void addRecord(Record record);

    PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize);
}
