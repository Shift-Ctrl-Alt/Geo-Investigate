package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
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
     * @return 自增的id
     */
    Long addLandType(LandType landType);

    /**
     * 添加土地属性
     * @param landAttribute
     */
    Long addLandAttribute(LandAttribute landAttribute);

    /**
     * 添加土地属性值
     * @param attrValues
     */
    void addLandAttrValue(LandAttributeValueVo attrValues);

    /**
     * 更新土地类型
     * @param landType
     */
    void updateLandType(LandType landType);

    /**
     * 删除该土地类型
     * @param landTypeId
     */
    void deleteLandType(Integer landTypeId);

    /**
     * 修改土地属性
     * @param landAttribute
     */
    void updateLandAttribute(LandAttribute landAttribute);

    /**
     * 修改土地属性值
     * @param landAttributeValue
     */
    void updateLandAttrValue(LandAttributeValue landAttributeValue);

    /**
     * 删除土地 属性
     * @param landAttrId
     */
    void deleteLandAttribute(Long landAttrId);

    /**
     * 删除土地属性值
     * @param landAttrValueId
     */
    void deleteLandAttrValue(Long landAttrValueId);
}
