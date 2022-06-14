package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.service.DisasterService;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;
import com.oymn.geoinvestigate.vo.DisasterAttributeVo;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Api("和灾害相关的接口")
public class DisasterController {
    
    @Autowired
    private DisasterService disasterService;

    /**
     * 获取灾害类型
     * @return
     */
    @ApiOperation("获取灾害类型")
    @GetMapping("disaster-type")
    public Result<List<DisasterType>> getDisasterType(){
        List<DisasterType> disasterTypeList = disasterService.getDisasterType();
        return Result.success(disasterTypeList);
    }

    /**
     * 获取灾害属性
     * @param disasterTypeId
     * @return
     */
    @ApiOperation("获取灾害的属性及属性值")
    @GetMapping("disaster-attribute")
    public Result<List<DisasterAttributeValueVo>> getDisasterAttribute(@ApiParam("灾害的id") Long disasterTypeId){
        List<DisasterAttributeValueVo> disasterAttrValueList = disasterService.getDisasterAttribute(disasterTypeId);
        return Result.success(disasterAttrValueList);
    }

    /**
     * 添加灾害类型
     * @param disasterType
     * @return
     */
    @ApiOperation("添加灾害类型")
    @PostMapping("disaster-type")
    public Result addDisasterType(@ApiParam("灾害类型对象") @RequestBody DisasterType disasterType){
        disasterService.addDisasterType(disasterType);
        return Result.success();
    }

    /**
     * 添加灾害属性
     * @param disasterAttrVo
     * @return
     */
    @ApiOperation("添加灾害属性")
    @PostMapping("disaster-attribute")
    public Result addDisasterAttr(@ApiParam("灾害属性封装类") @RequestBody DisasterAttributeVo disasterAttrVo){
        disasterService.addDisasterAttr(disasterAttrVo);
        return Result.success();
    }

    /**
     * 添加灾害属性值
     * @param disasterAttrValue
     * @return
     */
    @ApiOperation("添加灾害属性值")
    @PostMapping("disaster-attr-value")
    public Result addDisasterAttrValue(@ApiParam("灾害属性值封装类") @RequestBody DisasterAttributeValueVo disasterAttrValue){
        disasterService.addDisasterAttrValue(disasterAttrValue);
        return Result.success();
    }
    
}
