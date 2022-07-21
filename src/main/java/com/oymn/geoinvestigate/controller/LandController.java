package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.service.LandService;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List; 

@RestController
@Api("和土地相关的接口")
public class LandController {
    
    @Autowired
    private LandService landService;

    /**
     * 获取土地类型
     * @return
     */
    @ApiOperation("获取土地类型")
    @GetMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('getLandType')")
    public Result<List<LandTypeVo>> getLandType(){
        List<LandTypeVo> landTypeList = landService.getLandType();
        return Result.success(landTypeList);
    }

    /**
     * 获取土地属性及属性值
     * @param landTypeId
     * @return
     */
    @ApiOperation("获取土地属性及属性值")
    @GetMapping("land-attribute")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "landTypeId", value = "二级土地类型id",dataType = "Long", required = true)
    )
    @PreAuthorize("@ex.hasAuthority('getLandAttribute')")
    public Result<List<LandAttributeValueVo>> getLandAttribute(Long landTypeId){
        List<LandAttributeValueVo> landAttributeList = landService.getLandAttribute(landTypeId);
        return Result.success(landAttributeList);
    }

    /**
     * 添加土地类型
     * @param landType
     * @return
     */
    @ApiOperation("添加土地类型")
    @PostMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('addLandType')")
    public Result<Long> addLandType(@ApiParam("土地类型") @RequestBody LandType landType){
        Long id = landService.addLandType(landType);
        return Result.success(id);
    }

    /**
     * 添加土地属性
     * @param landAttribute
     * @return
     */
    @ApiOperation("添加土地属性")
    @PostMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('addLandAttribute')")
    public Result<Long> addLandAttribute(@ApiParam("土地属性包装类") @RequestBody LandAttribute landAttribute){
        Long id = landService.addLandAttribute(landAttribute);
        return Result.success(id);
    }

    /**
     * 添加土地属性值
     * @param attrValues
     * @return
     */
    @ApiOperation("添加土地属性值")
    @PostMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('addLandAttrValue')")
    public Result addLandAttrValue(@ApiParam("土地属性值的包装类")@RequestBody LandAttributeValueVo attrValues){
        landService.addLandAttrValue(attrValues);
        return Result.success();
    }

    /**
     * 修改土地类型
     * @param landType
     * @return
     */
    @ApiOperation("修改土地类型")
    @PutMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('updateLandType')")
    public Result updateLandType(@ApiParam("土地类型") @RequestBody LandType landType){
        landService.updateLandType(landType);
        return Result.success();
    }

    /**
     * 删除土地类型
     * @param landTypeId
     * @return
     */
    @ApiOperation("删除土地类型")
    @DeleteMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('deleteLandType')")
    public Result deleteLandType(@ApiParam("土地类型的id") @RequestParam Integer landTypeId){
        landService.deleteLandType(landTypeId);
        return Result.success();
    }
    
    @ApiOperation("修改土地属性")
    @PutMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('updateLandAttr')")
    public Result updateLandAttribute(@ApiParam("土地属性包装类") @RequestBody LandAttribute landAttribute){
        landService.updateLandAttribute(landAttribute);
        return Result.success();
    }
    
    @ApiOperation("修改土地属性值")
    @PutMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('updateLandAttrValue')")
    public Result updateLandAttrValue(@ApiParam("土地属性值类")@RequestBody LandAttributeValue landAttributeValue){
        landService.updateLandAttrValue(landAttributeValue);
        return Result.success();
    }
    
    @ApiOperation("删除土地属性")
    @DeleteMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('deleteLandAttr')")
    public Result deleteLandAttribute(@ApiParam("土地属性的id") @RequestParam Long landAttrId){
        landService.deleteLandAttribute(landAttrId);
        return Result.success();
    }
    
    @ApiOperation("删除土地属性值")
    @DeleteMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('deleteLandAttrValue')")
    public Result deleteLandAttrValue(@ApiParam("土地属性值的id") @RequestParam Long landAttrValueId){
        landService.deleteLandAttrValue(landAttrValueId);
        return Result.success();
    }

        
}
