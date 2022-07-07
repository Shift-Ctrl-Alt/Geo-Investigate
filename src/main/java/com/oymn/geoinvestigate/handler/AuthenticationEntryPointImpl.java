package com.oymn.geoinvestigate.handler;

import com.alibaba.fastjson.JSONObject;
import com.oymn.geoinvestigate.common.StatusCode;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.utils.WebUtil;
import com.oymn.geoinvestigate.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败，登录失败
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //抛出认证失败异常
        Result result = Result.fail(StatusCode.UNAUTHORIZED.getCode(), StatusCode.UNAUTHORIZED.getMsg());
        WebUtil.renderString(response, JSONObject.toJSONString(result));
    }
}
