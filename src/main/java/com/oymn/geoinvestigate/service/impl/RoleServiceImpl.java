package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.mapper.RoleDao;
import com.oymn.geoinvestigate.dao.pojo.Role;
import com.oymn.geoinvestigate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleDao roleDao;
    
    @Override
    public List<String> getPermissionByUserId(Long userId) {
        return roleDao.getPermissionByUserId(userId);
    }

    @Override
    public Collection<ConfigAttribute> getPermissionByPath(String url) {
        return roleDao.getPermissionByPath(url);
    }

    @Override
    public void setUserRole(Long userId, String roleName) {
        if(userId == null || roleName == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        //判断该角色是否存在
        Role role = roleDao.getRoleByName(roleName);
        if(role == null){
            throw new ConditionException("该角色不存在");
        }
        
        roleDao.setUserRole(userId, role.getId());
    }
}
