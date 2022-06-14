package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;
import com.oymn.geoinvestigate.vo.DisasterAttributeVo;

import java.util.List;

public interface DisasterService {

    /**
     * 获取灾害类型
     * @return
     */
    List<DisasterType> getDisasterType();

    /**
     * 获取灾害属性及属性值
     * @param disasterTypeId
     * @return
     */
    List<DisasterAttributeValueVo> getDisasterAttribute(Long disasterTypeId);

    /***
     * 添加灾害类型
     * @param disasterType
     */
    void addDisasterType(DisasterType disasterType);

    /**
     * 添加灾害属性
     * @param disasterAttrVo
     */
    void addDisasterAttr(DisasterAttributeVo disasterAttrVo);

    /**
     * 添加灾害属性值
     * @param disasterAttrValue
     */
    void addDisasterAttrValue(DisasterAttributeValueVo disasterAttrValue);
    
    
}
