package com.example.boot.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.boot.pojo.User;

import java.util.Date;

public class TokenTool {

    private  static final  long EXPIRE_TIME = 3*24*60*60*1000;

    private static final String TOKEN_SECRET = "ahjjqoe**jidjs??jaj";

    public static String createToken(User user) {
        String token = "";
        try {
            Date expireTime = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username",user.getUsername())
                    .withExpiresAt(expireTime)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException| JWTCreationException je){

        }
        return token;
    }

    public static Boolean verifyToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auto0").build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            System.out.println("username:"+decodedJWT.getClaim("username").asString());
        } catch (IllegalArgumentException|JWTCreationException e){
            return false;
        }
        return true;
    }


}
