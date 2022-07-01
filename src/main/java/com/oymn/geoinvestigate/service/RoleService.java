package com.oymn.geoinvestigate.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.List;

public interface RoleService {

    /**
     * 通过用户名获取用户的所有权限
     * @param userId
     * @return
     */
    List<String> getPermissionByUserId(Long userId);

    /**
     * 通过访问路径获取所需权限
     * @param url
     * @return
     */
    Collection<ConfigAttribute> getPermissionByPath(String url);

    /**
     * 给用户设置角色
     * @param userId
     * @param roleName
     */
    void setUserRole(Long userId, String roleName);
}
