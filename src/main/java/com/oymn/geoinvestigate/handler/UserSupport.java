package com.oymn.geoinvestigate.handler;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UserSupport {
    

    public Long getCurrentUserId(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("token");
        
        if(token == null || token == ""){
            throw new ConditionException("请登录");
        }
        
        Long userId = TokenUtil.verifyToken(token);

        if(userId < 0){
            throw new ConditionException("非法用户！");
        }
        return userId;
    }
}
