package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.List;

@Mapper
public interface RoleDao {
    
    List<String> getPermissionByUserId(Long userId);

    Collection<ConfigAttribute> getPermissionByPath(String url);

    Role getRoleByName(String roleName);

    void setUserRole(Long userId, Long roleId);
}
