package com.oymn.geoinvestigate.service;

import com.oymn.geoinvestigate.dao.pojo.User;

public interface LoginService {

    /**
     * 登录接口
     * @param user
     * @return
     * @throws Exception
     */
    String login(User user) throws Exception;

    /**
     * 注册接口
     * @param user
     */
    void register(User user);
    
}
