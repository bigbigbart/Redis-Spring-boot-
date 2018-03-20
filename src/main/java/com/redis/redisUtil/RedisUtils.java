package com.redis.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     删除某个键
     */
    public void del(String key){
        redisTemplate.delete(key);
    }


    /**
     String:存储字符串
     */
    public void SET(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String GET(String key){
        String str = stringRedisTemplate.opsForValue().get(key)+"";
        return str;
    }


    /**
     * List存储
     * 存  LPUSH KEY_NAME VALUE1.. VALUEN
     * 取 LINDEX KEY_NAME INDEX_POSITION    -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素。
     *
     * */
    public void LPUSH(String key, String value){
        redisTemplate.opsForList().leftPush(key, value);
    }

    public String LINDEX(String key, long pos){
        String str;
        str = redisTemplate.opsForList().index(key, pos) + "";
        //redisTemplate.opsForList().
        return str;
    }

    /**
     * Hash存储
     *存： HSET key field value
     *取：HGET key field
     */
    public void HSET(String h, Object hk, Object hv){
        redisTemplate.opsForHash().put(h, hk, hv);
    }

    public String HGET(String h, Object hk){
        String str =  redisTemplate.opsForHash().get(h, hk)+ "";
        return str;
    }


    /**
     * set存储
     * 	存： SADD key member1 [member2]
     * 	取：SMEMBERS key
     public void SADD(String key, ){
     redisTemplate.opsForSet().add();
     }
     */



    /**
     Object:存储对象
     */
    public void SETOJECT(Object obj, String key){
        redisTemplate.opsForValue().set(key, obj);
    }

    public Object GETOBJECT(String key){
        Object obj = redisTemplate.opsForValue().get(key);
        return obj;
    }


}
