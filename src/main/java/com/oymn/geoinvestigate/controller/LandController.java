package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.service.LandService;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
import com.oymn.geoinvestigate.vo.LandAttributeVo;
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
    @PreAuthorize("@ex.hasAuthority('land:list')")
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
    public Result addLandType(@ApiParam("土地类型") @RequestBody LandType landType){
        landService.addLandType(landType);
        return Result.success();
    }

    /**
     * 添加土地属性
     * @param landAttribute
     * @return
     */
    @ApiOperation("添加土地属性")
    @PostMapping("land-attribute")
    public Result addLandAttribute(@ApiParam("土地属性包装类") @RequestBody LandAttributeVo landAttribute){
        landService.addLandAttribute(landAttribute);
        return Result.success();
    }

    /**
     * 添加土地属性值
     * @param attrValues
     * @return
     */
    @ApiOperation("添加土地属性值")
    @PostMapping("land-attribute-value")
    public Result addLandAttrValue(@ApiParam("土地属性值的包装类")@RequestBody LandAttributeValueVo attrValues){
        landService.addLandAttrValue(attrValues);
        return Result.success();
    }
    
    
}
