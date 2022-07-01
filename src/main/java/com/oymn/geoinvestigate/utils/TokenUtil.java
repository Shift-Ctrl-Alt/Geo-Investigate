package com.oymn.geoinvestigate.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oymn.geoinvestigate.common.StatusCode;
import com.oymn.geoinvestigate.dao.exception.ConditionException;


import java.util.Calendar;
import java.util.Date;

/**
 * token工具类
 */
public class TokenUtil {
    
    private final static String ISSUER = "qianfazhe";

    public static String generateToken(Long userId) throws Exception {
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(), RSAUtil.getPrivateKey());
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);   //过期时间：1个月
        
        return JWT.create()
                .withKeyId(String.valueOf(userId))   //存放用户id
                .withIssuer(ISSUER)     //设置签发者
                .withExpiresAt(calendar.getTime())   //设置过期时间
                .sign(algorithm);

    }
    
    public static Long verifyToken(String token){
        
        try {
            Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(), RSAUtil.getPrivateKey());

            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getKeyId();
            return Long.valueOf(userId);
            
        } catch (TokenExpiredException e) {
            throw new ConditionException(StatusCode.TOKEN_EXPIRED.getCode(), StatusCode.TOKEN_EXPIRED.getMsg());
        }catch (Exception e){
            throw new ConditionException("非法用户token!");
        }
        
    }

    public static String generateRefreshToken(Long userId) throws Exception {
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(), RSAUtil.getPrivateKey());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 7);

        return JWT.create()
                .withKeyId(String.valueOf(userId))   //存放用户id
                .withIssuer(ISSUER)     //设置签发者
                .withExpiresAt(calendar.getTime())   //设置过期时间
                .sign(algorithm);
    }
}
