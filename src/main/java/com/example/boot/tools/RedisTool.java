package com.example.boot.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class RedisTool {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @RequestMapping("save")
    public String saveRedis(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return key;
    }

    public String getRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
