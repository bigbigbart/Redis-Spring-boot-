package com.redis.redisUtil;

import com.redis.dao.GameWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


/**消息接收*/
@Component
public class MessageReceiver implements MessageListener {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtilsl;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("Subscribe=====>>>>>");
        String channel = new String(message.getChannel());
        if(channel.equals("bart")){
            GameWay gameWay = (GameWay) redisTemplate.getDefaultSerializer().deserialize(message.getBody());
            System.out.println(gameWay.toString());
        }else{
            String message1 = (String) redisTemplate.getDefaultSerializer().deserialize(message.getBody());
            System.out.println(message1);
        }
        redisUtilsl.SET("glzp", "glzp222");


    }
}
