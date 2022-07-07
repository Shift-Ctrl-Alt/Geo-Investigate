package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface LandDao {
    
    List<LandType> getSubLandTypeById(Long id);

    List<LandType> getFirstLandType();
    
    List<LandAttribute> getAttrByLandTypeId(Long landTypeId);

    List<LandAttributeValue> getAttributeValue(Long attributeId);

    Long addLandType(LandType landType);

    LandType getLandTypeById(Long landTypeId);

    LandType getLandTypeByName(String nameChs, String nameEn);

    LandAttribute getAttrByNameAndLandType(@Param("landTypeId") Long landTypeId, @Param("nameChs") String nameChs, @Param("nameEn") String nameEn);

    LandAttribute getAttrByName(String nameChs, String nameEn);

    Long addLandAttr(LandAttribute landAttribute);

    void addLandAttrValues(@Param("attributeValues") List<LandAttributeValue> attributeValues);

    void updateLandType(LandType landType);

    void deleteLandType(Integer landTypeId);

    void deleteLandTypeByParentId(Integer landTypeId);
    
    void updateLandAttr(LandAttribute landAttribute);

    LandAttribute getAttrByAttrId(Long landAttrId);

    void updateLandAttrValue(LandAttributeValue landAttributeValue);

    void deleteLandAttribute(Long landAttrId);

    void deleteLandAttrValue(Long landAttrValueId);

    void deleteLandAttrValueByAttrId(Long landAttrId);
    
}
