package com.example.boot.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.boot.pojo.User;

import java.util.Date;
import java.util.HashMap;

public class TokenTool {

    private  static final  long EXPIRE_TIME = 3*24*60*60*1000;

    private static final String TOKEN_SECRET = "ahjjqoe**jidjs??jaj";

    public static String createToken(User user) {
        String token = "";
        try {
           token = JWT.create()
                   .withClaim("userId",user.getId())
                   .withClaim("userName",user.getUsername())
                   .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException| JWTCreationException je){

        }
        return token;
    }

    public static String  verifyToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            Claim userIdInt = decodedJWT.getClaim("userId");
            Claim userName = decodedJWT.getClaim("userName");
            return userName.asString();
        } catch (IllegalArgumentException | JWTVerificationException e){
            return "";
        }
    }

    public static String getCookie(String key,String cookie) {
        String[] cookies = cookie.split(";");
        HashMap<String,Object> map = new HashMap<>();
        for (String s : cookies) {
            String info = s.replace(" ","");
            String[] param = info.split("=");
            if (param.length > 1){
                map.put(param[0],param[1]);
            }
        }
        return map.get(key).toString();
    }

}
