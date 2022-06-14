package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.dao.mapper.UserRoleDao;
import com.oymn.geoinvestigate.dao.pojo.UserRole;
import com.oymn.geoinvestigate.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired
    private UserRoleDao userRoleDao;

    public List<UserRole> getUserRoleByUserId(Long userId) {
        return userRoleDao.getUserRoleByUserId(userId);
    }

    public void addUserRole(UserRole userRole) {
        userRole.setCreateTime(new Date());
        userRoleDao.addUserRole(userRole);
    }
    
}
