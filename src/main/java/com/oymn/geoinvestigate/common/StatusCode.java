package com.oymn.geoinvestigate.common;

public enum StatusCode {
    
    RESPONSE_SUCCESS(200, "success"),
    TOKEN_EXPIRED(555, "token过期!"),
    PARAMS_ERROR(201,"参数有误！"), 
    ACCESS_DENIED(202, "权限不足"), 
    UNAUTHORIZED(203, "用户认证失败请查询登录");
    
    private int code;
    private String msg;
    
    StatusCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
