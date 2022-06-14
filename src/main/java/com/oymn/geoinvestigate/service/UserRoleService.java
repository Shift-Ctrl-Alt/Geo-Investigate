package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getUserRoleByUserId(Long userId);

    void addUserRole(UserRole userRole);
}
