package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.DisasterDao;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.service.DisasterService;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;
import com.oymn.geoinvestigate.vo.DisasterAttributeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class DisasterServiceImpl implements DisasterService {

    @Autowired
    private DisasterDao disasterDao;

    @Override
    public List<DisasterType> getDisasterType() {
        return disasterDao.getDisasterType();
    }

    @Override
    public List<DisasterAttributeValueVo> getDisasterAttribute(Long disasterTypeId) {

        if (disasterTypeId == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }

        List<DisasterAttribute> disasterAttributeList = disasterDao.getDisasterAttribute(disasterTypeId);
        //去重
        //List<DisasterAttribute> disasterAttributeSet = disasterAttributeList.stream()
        //        .collect(
        //                collectingAndThen(
        //                        toCollection(
        //                                () -> new TreeSet<>(comparing(DisasterAttribute::getId))
        //                        ),
        //                        ArrayList::new
        //                )
        //        );

        List<DisasterAttributeValueVo> disasterAttrValueVoList = new ArrayList<>();
        for (DisasterAttribute disasterAttribute : disasterAttributeList) {
            DisasterAttributeValueVo disasterAttrValueVo = new DisasterAttributeValueVo(disasterTypeId, disasterAttribute.getId(), disasterAttribute.getNameChs(), disasterAttribute.getNameEn(), disasterAttribute.getUnit(), disasterAttribute.getRequired());
            List<DisasterAttributeValue> attributeValueList = disasterDao.getAttributeValue(disasterTypeId, disasterAttribute.getId());
            disasterAttrValueVo.setAttrValues(attributeValueList);
            disasterAttrValueVoList.add(disasterAttrValueVo);
        }

        return disasterAttrValueVoList;
    }

    @Override
    public void addDisasterType(DisasterType disasterType) {
        DisasterType dbDisasterType = disasterDao.getDisasterTypeByName(disasterType.getNameChs(), disasterType.getNameEn());
        if (dbDisasterType != null) {
            throw new ConditionException("该灾害类型已存在");
        }

        disasterType.setCreateTime(new Date());
        disasterType.setUpdateTime(new Date());
        disasterDao.addDisasterType(disasterType);
    }

    @Override
    public void addDisasterAttr(DisasterAttributeVo disasterAttrVo) {
        Long disasterTypeId = disasterAttrVo.getDisasterTypeId();
        String nameChs = disasterAttrVo.getNameChs();
        String nameEn = disasterAttrVo.getNameEn();

        DisasterType dbDisasterType = disasterDao.getDisasterTypeById(disasterTypeId);
        if (dbDisasterType == null) {
            throw new ConditionException("灾害类型不存在");
        }

        //判断灾害类型-属性表中是否存在该属性
        DisasterAttribute dbDisasterAttr = disasterDao.getAttrByNameAndTypeId(disasterTypeId, nameChs, nameEn);
        if (dbDisasterAttr != null) {
            throw new ConditionException("该属性已存在");
        }

        //判断属性表中是否存在该属性
        dbDisasterAttr = disasterDao.getAttrByName(nameChs, nameEn);
        Long disasterAttrId;
        if (dbDisasterAttr != null) {
            disasterAttrId = dbDisasterAttr.getId();
        } else {
            disasterAttrVo.setCreateTime(new Date());
            disasterAttrVo.setUpdateTime(new Date());
            disasterDao.addDisasterAttr(disasterAttrVo);
            disasterAttrId = disasterAttrVo.getId();
        }

        //添加灾害类型和属性的关联
        disasterDao.addDisasterTypeAndAttr(disasterTypeId, disasterAttrId, disasterAttrVo.getCreateTime(), disasterAttrVo.getUpdateTime());
    }

    @Override
    public void addDisasterAttrValue(DisasterAttributeValueVo disasterAttrValue) {
        Long disasterTypeId = disasterAttrValue.getDisasterTypeId();
        Long disasterAttrId = disasterAttrValue.getDisasterAttrId();

        DisasterType disasterType = disasterDao.getDisasterTypeById(disasterTypeId);
        if(disasterType == null){
            throw new ConditionException("该灾害类型不存在");
        }
        
        //判断该灾害是否拥有这个属性
        Integer typeAttrId = disasterDao.getTypeAndAttrId(disasterTypeId, disasterAttrId);
        if(typeAttrId == null){
            throw new ConditionException("该灾害属性不存在");
        }
        
        disasterDao.addDisasterAttrValue(typeAttrId, disasterAttrValue.getAttrValues());
    }
}
