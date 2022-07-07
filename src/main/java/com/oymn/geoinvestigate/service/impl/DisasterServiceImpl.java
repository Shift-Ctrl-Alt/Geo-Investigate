package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.DisasterDao;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttribute;
import com.oymn.geoinvestigate.dao.pojo.DisasterAttributeValue;
import com.oymn.geoinvestigate.dao.pojo.DisasterType;
import com.oymn.geoinvestigate.service.DisasterService;
import com.oymn.geoinvestigate.vo.DisasterAttributeValueVo;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            List<DisasterAttributeValue> attributeValueList = disasterDao.getAttributeValue(disasterAttribute.getId());
            disasterAttrValueVo.setAttrValues(attributeValueList);
            disasterAttrValueVoList.add(disasterAttrValueVo);
        }

        return disasterAttrValueVoList;
    }

    @Override
    public Integer addDisasterType(DisasterType disasterType) {
        DisasterType dbDisasterType = disasterDao.getDisasterTypeByName(disasterType.getNameChs(), disasterType.getNameEn());
        if (dbDisasterType != null) {
            throw new ConditionException("该灾害类型已存在");
        }

        disasterType.setCreateTime(new Date());
        disasterType.setUpdateTime(new Date());
        return disasterDao.addDisasterType(disasterType);
    }

    @Override
    public Long addDisasterAttr(DisasterAttribute disasterAttr) {
        Long disasterTypeId = disasterAttr.getDisasterTypeId();
        String nameChs = disasterAttr.getNameChs();
        String nameEn = disasterAttr.getNameEn();

        DisasterType dbDisasterType = disasterDao.getDisasterTypeById(disasterTypeId);
        if (dbDisasterType == null) {
            throw new ConditionException("灾害类型不存在");
        }

        //判断该类型是否已经存在该属性
        DisasterAttribute dbDisasterAttr = disasterDao.getAttrByNameAndTypeId(disasterTypeId, nameChs, nameEn);
        if (dbDisasterAttr != null) {
            throw new ConditionException("该属性已存在");
        }
        
        disasterAttr.setCreateTime(new Date());
        disasterAttr.setUpdateTime(new Date());
        disasterDao.addDisasterAttr(disasterAttr);
        return disasterAttr.getId();
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
        DisasterAttribute disasterAttribute = disasterDao.getAttrById(disasterAttrId);
        if(disasterAttribute == null){
            throw new ConditionException("该灾害属性不存在");
        }

        List<DisasterAttributeValue> attributeValues = disasterAttrValue.getAttrValues();
        disasterDao.addDisasterAttrValue(attributeValues);
    }

    @Override
    public void updateDisasterType(DisasterType disasterType) {
        if (disasterType == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        disasterType.setUpdateTime(new Date());
        disasterDao.updateDisasterType(disasterType);
    }

    @Override
    public void updateDisasterAttribute(DisasterAttribute disasterAttribute) {
        if (disasterAttribute == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }        
        
        disasterAttribute.setUpdateTime(new Date());
        disasterDao.updateDisasterAttribute(disasterAttribute);
    }

    @Override
    public void updateDisasterAttrValue(DisasterAttributeValue disasterAttributeValue) {

        if (disasterAttributeValue == null) {
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        disasterAttributeValue.setUpdateTime(new Date());
        disasterDao.updateDisasterAttrValue(disasterAttributeValue);
    }

    @Override
    public void deleteDisasterType(Long disasterTypeId) {
        if(disasterTypeId == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        disasterDao.deleteDisasterType(disasterTypeId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDisasterAttribute(Long disasterAttributeId) {
        if(disasterAttributeId == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        //先删除属性
        disasterDao.deleteDisasterAttribute(disasterAttributeId);
        
        //再删除该属性的属性值
        disasterDao.deleteAttrValueByAttrId(disasterAttributeId);
    }

    @Override
    public void deleteDisasterAttrValue(Long disasterAttrValueId) {
        if(disasterAttrValueId == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        disasterDao.deleteAttrValueByValueId(disasterAttrValueId);
    }
}
