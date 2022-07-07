package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.PageResult;
import com.oymn.geoinvestigate.dao.pojo.Record;

public interface RecordService {

    /**
     * 添加记录
     * @param record
     */
    Long addRecord(Record record);

    /**
     * 分页查找记录
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize);

    /**
     * 更新记录
     * @param record
     */
    void updateRecord(Record record);

    /**
     * 删除记录
     * @param currentUserId
     * @param recordId
     */
    void deleteRecord(Long currentUserId, Long recordId);
}
