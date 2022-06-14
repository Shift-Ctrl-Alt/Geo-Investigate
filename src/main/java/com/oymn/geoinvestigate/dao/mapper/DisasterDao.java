package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.vo.DisasterAttributeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DisasterDao {
    
    List<DisasterType> getDisasterType();

    List<DisasterAttribute> getDisasterAttribute(Long disasterTypeId);

    List<DisasterAttributeValue> getAttributeValue(Long disasterTypeId, Long attributeId);

    DisasterType getDisasterTypeByName(String nameChs, String nameEn);

    void addDisasterType(DisasterType disasterType);

    DisasterType getDisasterTypeById(Long disasterTypeId);

    DisasterAttribute getAttrByNameAndTypeId(Long disasterTypeId, String nameChs, String nameEn);

    DisasterAttribute getAttrByName(String nameChs, String nameEn);

    void addDisasterAttr(DisasterAttributeVo disasterAttrVo);

    void addDisasterTypeAndAttr(Long disasterTypeId, Long disasterAttrId, Date createTime, Date updateTime);

    DisasterAttribute getAttrById(Long disasterAttrId);

    Integer getTypeAndAttrId(Long disasterTypeId, Long disasterAttrId);

    void addDisasterAttrValue(@Param("typeAttrId") Integer typeAttrId, @Param("attrValues") List<DisasterAttributeValue> attrValues);
}
