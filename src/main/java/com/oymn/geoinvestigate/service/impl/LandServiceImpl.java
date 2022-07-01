package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.LandDao;
import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.service.LandService;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
import com.oymn.geoinvestigate.vo.LandAttributeVo;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    private LandDao landDao;

    /**
     * 获取土地类型
     *
     * @return
     */
    @Override
    public List<LandTypeVo> getLandType() {
        //获取一级分类
        List<LandType> firstLandTypeList = landDao.getFirstLandType();

        //获取二级分类
        List<LandTypeVo> landTypeList = new ArrayList<>();
        for (LandType landType : firstLandTypeList) {
            LandTypeVo landTypeVo = new LandTypeVo(landType.getId(), landType.getNameChs(), landType.getNameEn());
            List<LandType> subLandType = landDao.getSubLandTypeById(landType.getId());
            landTypeVo.setSubLandType(subLandType);
            landTypeList.add(landTypeVo);
        }

        return landTypeList;
    }

    /**
     * 获取土地的属性
     *
     * @param landTypeId
     * @return
     */
    @Override
    public List<LandAttributeValueVo> getLandAttribute(Long landTypeId) {

        if (landTypeId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }

        List<LandAttribute> landAttributeList = landDao.getAttrByLandTypeId(landTypeId);
        //去重
        //List<LandAttribute> landAttributeSet = landAttributeList.stream()
        //        .collect(
        //                collectingAndThen(
        //                        toCollection(
        //                                () -> new TreeSet<>(comparing(LandAttribute::getId))
        //                        ),
        //                        ArrayList::new
        //                )
        //        );


        List<LandAttributeValueVo> landAttrValueVoList = new ArrayList<>();
        for (LandAttribute landAttribute : landAttributeList) {
            LandAttributeValueVo landAttrValueVo = new LandAttributeValueVo(landTypeId, landAttribute.getId(), landAttribute.getNameChs(), landAttribute.getNameEn(), landAttribute.getUnit(), landAttribute.getRequired());
            List<LandAttributeValue> attributeValueList = landDao.getAttributeValue(landTypeId, landAttribute.getId());
            landAttrValueVo.setAttributeValues(attributeValueList);
            landAttrValueVoList.add(landAttrValueVo);
        }

        return landAttrValueVoList;
    }

    @Override
    public void addLandType(LandType landType) {
        Long parentId = landType.getParentId();
        if (parentId != null) {
            LandType parentType = landDao.getLandTypeById(parentId);
            if (parentType == null) {
                throw new ConditionException("父类型不存在");
            }
        }

        LandType dbType = landDao.getLandTypeByName(landType.getNameChs(), landType.getNameEn());
        if (dbType != null) {
            throw new ConditionException("该土地类型已存在");
        }

        landType.setCreateTime(new Date());
        landType.setUpdateTime(new Date());
        landDao.addLandType(landType);
    }

    @Override
    public void addLandAttribute(LandAttributeVo landAttribute) {
        //判断土地类型-土地属性表是否存在该属性
        Long landTypeId = landAttribute.getLandTypeId();
        String nameChs = landAttribute.getNameChs();
        String nameEn = landAttribute.getNameEn();
        LandAttribute dbLandAttr = landDao.getAttrByNameAndLandType(landTypeId, nameChs, nameEn);
        if (dbLandAttr != null) {
            throw new ConditionException("该土地属性已存在");
        }

        //判断土地属性表是否存在该属性
        dbLandAttr = landDao.getAttrByName(landAttribute.getNameChs(), landAttribute.getNameEn());
        Long landAttrId;
        if (dbLandAttr != null) {
            landAttrId = dbLandAttr.getId();
        } else {
            landAttribute.setCreateTime(new Date());
            landAttribute.setUpdateTime(new Date());
            landDao.addLandAttr(landAttribute);
            landAttrId = landAttribute.getId();
        }

        //添加土地类型和土地属性的关联
        landDao.addLandTypeAndAttr(landTypeId, landAttrId, landAttribute.getCreateTime(), landAttribute.getUpdateTime());

    }

    @Override
    public void addLandAttrValue(LandAttributeValueVo attrValues) {
        Long landTypeId = attrValues.getLandTypeId();
        Long landAttrId = attrValues.getLandAttrId();

        LandType landType = landDao.getLandTypeById(landTypeId);
        if (landType == null) {
            throw new ConditionException("该土地类型不存在");
        }

        //判断是否存在该土地和属性的关联
        Integer typeAttrId = landDao.getTypeAndAttrId(landTypeId, landAttrId);
        if (typeAttrId == null) {
            throw new ConditionException("该属性不存在");
        }

        List<LandAttributeValue> attributeValues = attrValues.getAttributeValues();
        landDao.addLandAttrValues(typeAttrId, attributeValues);
    }


}
