package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;

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

    /**
     * 添加灾害类型
     * @param disasterType
     * @return 自增的id
     */
    Long addDisasterType(DisasterType disasterType);

    /**
     * 添加灾害属性
     * @param disasterAttr
     */
    Long addDisasterAttr(DisasterAttribute disasterAttr);

    /**
     * 添加灾害属性值
     * @param disasterAttrValue
     */
    void addDisasterAttrValue(DisasterAttributeValueVo disasterAttrValue);

    /**
     * 更新灾害类型
     * @param disasterType
     */
    void updateDisasterType(DisasterType disasterType);

    /**
     * 更新灾害属性
     * @param disasterAttribute
     */
    void updateDisasterAttribute(DisasterAttribute disasterAttribute);

    /**
     * 更新灾害属性值
     * @param disasterAttributeValue
     */
    void updateDisasterAttrValue(DisasterAttributeValue disasterAttributeValue);

    /**
     * 删除灾害类型
     * @param disasterTypeId
     */
    void deleteDisasterType(Long disasterTypeId);

    /**
     * 删除灾害属性
     * @param disasterAttributeId
     */
    void deleteDisasterAttribute(Long disasterAttributeId);

    /**
     * 删除灾害属性值
     * @param disasterAttrValueId
     */
    void deleteDisasterAttrValue(Long disasterAttrValueId);
    
}
