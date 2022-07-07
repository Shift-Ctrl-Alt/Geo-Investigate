package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.RecordDao;
import com.oymn.geoinvestigate.dao.pojo.PageResult;
import com.oymn.geoinvestigate.dao.pojo.Record;
import com.oymn.geoinvestigate.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static javafx.scene.input.KeyCode.L;

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    private RecordDao recordDao;
    
    @Override
    public Long addRecord(Record record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        recordDao.addRecord(record);
        return record.getId();
    }

    @Override
    public PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize) {
        if(userId == null || pageNo == null || pageSize == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        int i = 0;
        Long num = Long.valueOf(i);
        
        //封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        //获取本次查询到的真实数据条数
        Integer count = recordDao.getRecordCount(params);
        List<Record> recordList = new ArrayList<>();
        if(count > 0){
            recordList = recordDao.getRecords(params);
        }
        
        return new PageResult<>(count, recordList);
    }

    @Override
    public void updateRecord(Record record) {
        record.setUpdateTime(new Date());
        recordDao.updateRecord(record);
    }

    @Override
    public void deleteRecord(Long currentUserId, Long recordId) {
        Record record = recordDao.getRecordById(recordId);
        if(record == null){
            throw new ConditionException("该记录不存在");
        }

        Long userId = record.getUserId();
        if(currentUserId != userId){
            throw new ConditionException("记录所有者不是该登录用户");
        }
        
        recordDao.deleteRecord(recordId);
    }
}
