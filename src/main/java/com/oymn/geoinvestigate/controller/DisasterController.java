package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.service.DisasterService;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("@ex.hasAuthority('getDisasterType')")
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
    @ApiImplicitParams(
            @ApiImplicitParam(name = "disasterTypeId", value = "灾害类型id",dataType = "Long", required = true)
    )
    @PreAuthorize("@ex.hasAuthority('getDisasterAttribute')")
    public Result<List<DisasterAttributeValueVo>> getDisasterAttribute(Long disasterTypeId){
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
    @PreAuthorize("@ex.hasAuthority('addDisasterType')")
    public Result<Long> addDisasterType(@ApiParam("灾害类型对象") @RequestBody DisasterType disasterType){
        Long id = disasterService.addDisasterType(disasterType);
        return Result.success(id);
    }

    /**
     * 添加灾害属性
     * @param disasterAttr
     * @return
     */
    @ApiOperation("添加灾害属性")
    @PostMapping("disaster-attribute")
    @PreAuthorize("@ex.hasAuthority('addDisasterAttribute')")
    public Result<Long> addDisasterAttribute(@ApiParam("灾害属性封装类") @RequestBody DisasterAttribute disasterAttr){
        Long id = disasterService.addDisasterAttr(disasterAttr);
        return Result.success(id);
    }

    /**
     * 添加灾害属性值
     * @param disasterAttrValue
     * @return
     */
    @ApiOperation("添加灾害属性值")
    @PostMapping("disaster-attr-value")
    @PreAuthorize("@ex.hasAuthority('addDisasterAttrValue')")
    public Result addDisasterAttrValue(@ApiParam("灾害属性值封装类") @RequestBody DisasterAttributeValueVo disasterAttrValue){
        disasterService.addDisasterAttrValue(disasterAttrValue);
        return Result.success();
    }

    /**
     * 更新灾害类型
     * @param disasterType
     * @return
     */
    @ApiOperation("修改灾害类型")
    @PutMapping("disaster-type")
    @PreAuthorize("@ex.hasAuthority('updateDisasterType')")
    public Result updateDisasterType(@ApiParam("灾害类型封装类") @RequestBody DisasterType disasterType){
        disasterService.updateDisasterType(disasterType);
        return Result.success();
    }

    /**
     * 更新灾害属性
     * @param disasterAttribute
     * @return
     */
    @ApiOperation("修改灾害属性")
    @PutMapping("disaster-attribute")
    @PreAuthorize("@ex.hasAuthority('updateDisasterAttribute')")
    public Result updateDisasterAttribute(@ApiParam("灾害属性封装类") @RequestBody DisasterAttribute disasterAttribute){
        disasterService.updateDisasterAttribute(disasterAttribute);
        return Result.success();
    }

    /**
     * 更新灾害属性值
     * @param disasterAttributeValue
     * @return
     */
    @ApiOperation("修改灾害属性值")
    @PutMapping("disaster-attribute-value")
    @PreAuthorize("@ex.hasAuthority('updateDisasterAttrValue')")
    public Result updateDisasterAttrValue(@ApiParam("灾害属性值封装类") @RequestBody DisasterAttributeValue disasterAttributeValue){
        disasterService.updateDisasterAttrValue(disasterAttributeValue);
        return Result.success();
    }

    /**
     * 删除灾害类型
     * @param disasterTypeId
     * @return
     */
    @ApiOperation("删除灾害类型")
    @DeleteMapping("disaster-type")
    @PreAuthorize("@ex.hasAuthority('deleteDisasterType')")
    public Result deleteDisasterType(@ApiParam("灾害类型id") Long disasterTypeId){
        disasterService.deleteDisasterType(disasterTypeId);
        return Result.success();
    }

    /**
     * 删除灾害属性
     * @param disasterAttributeId
     * @return
     */
    @ApiOperation("删除灾害属性")
    @DeleteMapping("disaster-attribute")
    @PreAuthorize("@ex.hasAuthority('deleteDisasterAttribute')")
    public Result deleteDisasterAttribute(@ApiParam("灾害属性id") Long disasterAttributeId){
        disasterService.deleteDisasterAttribute(disasterAttributeId);
        return Result.success();
    }

    @ApiOperation("删除灾害属性值")
    @DeleteMapping("disaster-attribute-value")
    @PreAuthorize("@ex.hasAuthority('deleteDisasterAttrValue')")
    public Result deleteDisasterAttrValue(@ApiParam("灾害属性值id") Long disasterAttrValueId){
        disasterService.deleteDisasterAttrValue(disasterAttrValueId);
        return Result.success();
    }
}
