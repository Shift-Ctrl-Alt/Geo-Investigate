package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.service.FileService;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RecordController {
    
    @Autowired
    private FileService fileService;

    @ApiOperation("上传图片的方法")
    @PostMapping("uploadImg")
    public Result uploadFile(@RequestParam(value = "file",required = true) MultipartFile uploadImg,
                             HttpServletRequest request) {
        fileService.uploadFile(uploadImg,request);
        return Result.success();
    }
    
    @ApiOperation("提交记录")
    @PostMapping("addRecord")
    public Result addRecord(){
        
        return Result.success();
    }
    
}
