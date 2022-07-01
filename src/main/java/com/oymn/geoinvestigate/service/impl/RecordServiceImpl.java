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

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    private RecordDao recordDao;
    
    @Override
    public void addRecord(Record record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        recordDao.addRecord(record);
    }

    @Override
    public PageResult<Record> getRecords(Long userId, Integer pageNo, Integer pageSize) {
        if(userId == null || pageNo == null || pageSize == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        //封装参数
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        //获取本次查询到的真实数据条数
        int count = recordDao.getRecordCount(params);
        List<Record> recordList = new ArrayList<>();
        if(count > 0){
            recordList = recordDao.getRecords(params);
        }
        
        return new PageResult<>(count, recordList);
    }


}
