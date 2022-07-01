package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.User;

public interface UserService {
    
    User getUserByName(String username);

    void addUser(User user);
}
