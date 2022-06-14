package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
import com.oymn.geoinvestigate.vo.LandAttributeVo;
import com.oymn.geoinvestigate.vo.LandTypeVo;

import java.util.List;

public interface LandService {

    /**
     * 获取土地类型
     * @return
     */
    List<LandTypeVo> getLandType();

    /**
     * 获取土地属性
     * @param landTypeId
     * @return
     */
    List<LandAttributeValueVo> getLandAttribute(Long landTypeId);

    /**
     * 添加土地类型
     * @param landType
     */
    void addLandType(LandType landType);

    /**
     * 添加土地属性
     * @param landAttribute
     */
    void addLandAttribute(LandAttributeVo landAttribute);

    /**
     * 添加土地属性值
     * @param attrValues
     */
    void addLandAttrValue(LandAttributeValueVo attrValues);
    
}
