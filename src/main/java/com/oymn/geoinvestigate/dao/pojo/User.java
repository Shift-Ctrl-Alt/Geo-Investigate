package com.oymn.geoinvestigate.dao.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel("用户信息 User")
public class User {
    
    private Long id;
    
    private String username;
    
    private String phone;
    
    private String email;
    
    private String password;
}
