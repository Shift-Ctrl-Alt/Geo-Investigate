package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.User;
import com.oymn.geoinvestigate.service.LoginService;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("登录注册的接口")
//@RestController
@RequestMapping("/user")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param user 
     * @return
     */
    @PostMapping("login")
    public Result<String> login(@RequestBody User user) throws Exception {
        String token = loginService.login(user);
        return Result.success(token);
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping("register")
    public Result register(@RequestBody User user){
        loginService.register(user);
        return Result.success();
    }
}
