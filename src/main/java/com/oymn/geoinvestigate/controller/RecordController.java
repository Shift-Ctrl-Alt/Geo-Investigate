package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.PageResult;
import com.oymn.geoinvestigate.dao.pojo.Record;
import com.oymn.geoinvestigate.handler.UserSupport;
import com.oymn.geoinvestigate.service.FileService;
import com.oymn.geoinvestigate.service.RecordService;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 记录的相关接口
 */
@Api("记录的相关接口")
@RestController
public class RecordController {
    
    @Autowired
    private FileService fileService;
    
    @Autowired
    private RecordService recordService;
    
    @Autowired
    private UserSupport userSupport;

    /**
     * 添加图片
     * @param uploadImg  上传的图片
     * @param request  请求
     * @return 该图片的访问地址
     */
    @ApiOperation("上传图片的方法")
    @PostMapping("img")
    public Result uploadFile(@RequestParam(value = "file",required = true) MultipartFile uploadImg,
                             HttpServletRequest request) {
        String imgPath = fileService.uploadFile(uploadImg, request);
        return Result.success(imgPath);
    }

    /**
     * 添加记录
     * @param record
     * @return
     */
    @ApiOperation("添加记录")
    @PostMapping("invest-record")
    public Result addRecord(@ApiParam("调查记录封装类") @RequestBody Record record){
        recordService.addRecord(record);
        return Result.success();
    }

    /**
     * 查询记录
     * @param pageSize
     * @param pageNo
     * @return
     */
    @ApiOperation("查询记录")
    @GetMapping("invest-record")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页多少条记录", required = true),
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = true)
    })
    public Result<PageResult<Record>> getRecords(@RequestParam Integer pageSize,
                                                 @RequestParam Integer pageNo){
        Long userId = userSupport.getCurrentUserId();
        PageResult<Record> recordList = recordService.getRecords(userId, pageNo, pageSize);
        return Result.success(recordList);
    }
    
}
