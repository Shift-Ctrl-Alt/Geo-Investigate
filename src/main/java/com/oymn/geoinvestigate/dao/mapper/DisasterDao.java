package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DisasterDao {
    
    List<DisasterType> getDisasterType();

    List<DisasterAttribute> getDisasterAttribute(Long disasterTypeId);

    List<DisasterAttributeValue> getAttributeValue(Long attributeId);

    DisasterType getDisasterTypeByName(@Param("nameChs") String nameChs, @Param("nameEn") String nameEn);

    Integer addDisasterType(DisasterType disasterType);

    DisasterType getDisasterTypeById(Long disasterTypeId);

    DisasterAttribute getAttrByNameAndTypeId(@Param("disasterTypeId") Long disasterTypeId, @Param("nameChs") String nameChs, @Param("nameEn") String nameEn);

    DisasterAttribute getAttrByName(String nameChs, String nameEn);

    Long addDisasterAttr(DisasterAttribute disasterAttr);

    DisasterAttribute getAttrById(Long disasterAttrId);
    
    void addDisasterAttrValue(@Param("attrValues") List<DisasterAttributeValue> attrValues);

    void updateDisasterType(DisasterType disasterType);

    void updateDisasterAttribute(DisasterAttribute disasterAttribute);

    void updateDisasterAttrValue(DisasterAttributeValue disasterAttributeValue);

    void deleteDisasterType(Long disasterTypeId);

    void deleteDisasterAttribute(Long disasterAttributeId);

    void deleteAttrValueByAttrId(Long disasterAttributeId);

    void deleteAttrValueByValueId(Long disasterAttrValueId);
    
}
