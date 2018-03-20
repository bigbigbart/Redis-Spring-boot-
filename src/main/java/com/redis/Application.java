package com.redis;

import com.redis.redisUtil.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    @Autowired
    private RedisUtils redisUtils;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }


}
