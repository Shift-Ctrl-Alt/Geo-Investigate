package com.oymn.geoinvestigate.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oymn.geoinvestigate.common.RoleConstant;
import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.dao.pojo.LoginUser;
import com.oymn.geoinvestigate.dao.pojo.User;
import com.oymn.geoinvestigate.service.LoginService;
import com.oymn.geoinvestigate.service.RoleService;
import com.oymn.geoinvestigate.service.UserService;
import com.oymn.geoinvestigate.utils.RSAUtil;
import com.oymn.geoinvestigate.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    
    //用于对用户的认证
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    //用于对密码的加密
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String login(User user) throws Exception {
        //使用 authenticationManager 来对用户进行认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        
        //如果认证没通过
        if(authenticate == null){
            throw new ConditionException("登录认证失败");
        }
        
        //认证通过，生成token，存入redis中，并返回给前端
        //这里的loginUser是在过滤器阶段的UserDetail接口中，查询数据库是否存在该用户时存进去的
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userId = loginUser.getUser().getId();
        String token = TokenUtil.generateToken(userId);
        
        //存入redis中
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(loginUser));
        
        return token;
    }

    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        
        //用户名或密码为空
        if(!StringUtils.hasText(username) || !StringUtils.hasText(password)){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }

        //该用户名是否被占用了
        User dbUser = userService.getUserByName(username);
        if(dbUser != null){
            throw new ConditionException("该用户名已经被注册了");
        }

        //TODO 前端如果有对密码进行加密，则需要进行解密
/*
        String rawPassword;
        try {
            //前端传输过程中加密，需要进行解密
            rawPassword = RSAUtil.decrypt(password);
        } catch (Exception e) {
            throw new ConditionException("密码解密失败");
        }
*/

        //使用SpringSecurity的passwordEncoder进行加密
        String newPwd = passwordEncoder.encode(password);
        user.setPassword(newPwd);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        
        userService.addUser(user);
        
        //todo: 添加用户默认角色
        roleService.setUserRole(user.getId(), RoleConstant.ORDINARY_USER);
    }

    @Override
    public void logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisTemplate.delete("TOKEN_" + token);
    }
}
