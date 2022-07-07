package com.oymn.geoinvestigate.controller;

import com.oymn.geoinvestigate.dao.pojo.User;
import com.oymn.geoinvestigate.service.LoginService;
import com.oymn.geoinvestigate.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api("登录注册的接口")
@RestController
@RequestMapping("/user")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param user 
     * @return
     */
    @ApiOperation("登录")
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
    @ApiOperation("注册")
    @PostMapping("register")
    public Result register(@RequestBody User user){
        loginService.register(user);
        return Result.success();
    }

    /**
     * 登出接口
     * @param request
     * @return
     */
    @ApiOperation("登出")
    @PostMapping("logout")
    public Result logout(HttpServletRequest request){
        loginService.logout(request);
        return Result.success();
    }
}
