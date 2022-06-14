package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.vo.LandAttributeVo;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface LandDao {
    
    List<LandType> getSubLandTypeById(Long id);

    List<LandType> getFirstLandType();
    
    List<LandAttribute> getAttrByLandTypeId(Long landTypeId);

    List<LandAttributeValue> getAttributeValue(Long landTypeId, Long attributeId);

    void addLandType(LandType landType);

    LandType getLandTypeById(Long landTypeId);

    LandType getLandTypeByName(String nameChs, String nameEn);

    LandAttribute getAttrByNameAndLandType(Long landTypeId, String nameChs, String nameEn);

    LandAttribute getAttrByName(String nameChs, String nameEn);

    void addLandAttr(LandAttributeVo landAttribute);

    void addLandTypeAndAttr(Long landTypeId, Long landAttrId, Date createTime, Date updateTime);

    //获取土地类型和属性之间的关联id
    Integer getTypeAndAttrId(Long landTypeId, Long landAttrId);

    void addLandAttrValues(@Param("typeAttrId") Integer typeAttrId, @Param("attributeValues") List<LandAttributeValue> attributeValues);
    
}
