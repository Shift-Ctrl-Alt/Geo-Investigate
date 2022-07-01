package com.oymn.geoinvestigate.dao.mapper;

import com.oymn.geoinvestigate.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    
    void addUser(User user);

    User getUserByName(String username);
}
