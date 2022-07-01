package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.dao.mapper.UserDao;
import com.oymn.geoinvestigate.dao.pojo.User;
import com.oymn.geoinvestigate.service.UserService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
