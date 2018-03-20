package com.redis.redisUtil;

import com.redis.dao.GameWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

/*消息发布*/
@Component
public class MessagePublish {
    @Autowired
    private RedisTemplate redisTemplate;

    public MessagePublish(RedisTemplate redisTemplate){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                GameWay gameWay = new GameWay("glzp", "guangxi");
                //RedisUtils RedisUtils
                redisTemplate.convertAndSend("bart", gameWay);

                redisTemplate.convertAndSend("lisa", "lisa is beatuy!!");
                System.out.println("Published===>>>>>>>>>");
                this.cancel();
            }
        }, 3000);// 这里百毫秒
    }

}
