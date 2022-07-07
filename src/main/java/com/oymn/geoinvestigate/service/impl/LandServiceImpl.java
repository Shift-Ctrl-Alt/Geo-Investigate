package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.LandDao;
import com.oymn.geoinvestigate.dao.pojo.LandAttribute;
import com.oymn.geoinvestigate.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.service.LandService;
import com.oymn.geoinvestigate.vo.LandAttributeValueVo;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 获取土地的属性和属性值
     * @param landTypeId
     * @return
     */
    @Override
    public List<LandAttributeValueVo> getLandAttribute(Long landTypeId) {

        if (landTypeId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }

        //获取该土地类型所具有的属性
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
            List<LandAttributeValue> attributeValueList = landDao.getAttributeValue(landAttribute.getId());
            landAttrValueVo.setAttributeValues(attributeValueList);
            landAttrValueVoList.add(landAttrValueVo);
        }

        return landAttrValueVoList;
    }

    @Override
    public Long addLandType(LandType landType) {
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
        return landDao.addLandType(landType);
    }

    @Override
    public Long addLandAttribute(LandAttribute landAttribute) {
        //判断该土地类型是否存在该属性
        Long landTypeId = landAttribute.getLandTypeId();
        String nameChs = landAttribute.getNameChs();
        String nameEn = landAttribute.getNameEn();
        LandAttribute dbLandAttr = landDao.getAttrByNameAndLandType(landTypeId, nameChs, nameEn);
        if (dbLandAttr != null) {
            throw new ConditionException("该土地属性已存在");
        }
        
        landAttribute.setCreateTime(new Date());
        landAttribute.setUpdateTime(new Date());
        landDao.addLandAttr(landAttribute);
        return landAttribute.getId();
    }

    @Override
    public void addLandAttrValue(LandAttributeValueVo attrValues) {
        Long landTypeId = attrValues.getLandTypeId();
        Long landAttrId = attrValues.getLandAttrId();

        LandType landType = landDao.getLandTypeById(landTypeId);
        if (landType == null) {
            throw new ConditionException("该土地类型不存在");
        }

        //判断是否存在该属性
        LandAttribute landAttribute = landDao.getAttrByAttrId(landAttrId);
        if(landAttribute == null){
            throw new ConditionException("该土地属性不存在");
        }

        List<LandAttributeValue> attributeValues = attrValues.getAttributeValues();
        landDao.addLandAttrValues(attributeValues);
    }

    @Override
    public void updateLandType(LandType landType) {

        if (landType == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        landType.setUpdateTime(new Date());
        landDao.updateLandType(landType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLandType(Integer landTypeId) {

        if (landTypeId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        landDao.deleteLandType(landTypeId);
        //子类型也一并删除
        landDao.deleteLandTypeByParentId(landTypeId);
    }

    @Override
    public void updateLandAttribute(LandAttribute landAttribute) {

        if (landAttribute == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        landAttribute.setUpdateTime(new Date());
        landDao.updateLandAttr(landAttribute);
    }

    @Override
    public void updateLandAttrValue(LandAttributeValue landAttributeValue) {

        if (landAttributeValue == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        landAttributeValue.setUpdateTime(new Date());
        landDao.updateLandAttrValue(landAttributeValue);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLandAttribute(Long landAttrId) {

        if (landAttrId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        //先删除土地属性
        landDao.deleteLandAttribute(landAttrId);
        //再删除土地属性值
        landDao.deleteLandAttrValueByAttrId(landAttrId);
    }

    @Override
    public void deleteLandAttrValue(Long landAttrValueId) {

        if (landAttrValueId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        landDao.deleteLandAttrValue(landAttrValueId);
    }


}
