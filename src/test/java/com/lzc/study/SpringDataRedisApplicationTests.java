package com.lzc.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzc.study.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class SpringDataRedisApplicationTests {

    @Autowired
    private RedisTemplate<Object,Object>  redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void testString()
    {
        //写入一条K/V
        redisTemplate.opsForValue().set("company", "google");
        stringRedisTemplate.opsForValue().set("club","皇家马德里");
    }

    private   static final ObjectMapper mapper=new ObjectMapper();
    @Test
    void testsaveUser() throws JsonProcessingException {
            redisTemplate.opsForValue().set("user:01",new User(10,"riha","china",22));
            User obj= (User) redisTemplate.opsForValue().get("user:01");
            System.out.println(obj);
            User user=new User(12,"kaynewest","america",40);
            //手动序列化  把对象序列化为json
            String JSON= mapper.writeValueAsString(user);
             stringRedisTemplate.opsForValue().set("user:02",JSON);
             String jsonuser=stringRedisTemplate.opsForValue().get("user:02");
             //手动反序列化 把读取到的json反序列化为对象
             User user1=mapper.readValue(jsonuser,User.class);
        System.out.println(user1);
        }
        @Test
     void  testHash()
        {
            stringRedisTemplate.opsForHash().put("user:100","name","cole");
            stringRedisTemplate.opsForHash().put("user:100","age","30");
         Map<Object,Object> map= stringRedisTemplate.opsForHash().entries("user:100");
            System.out.println(map);
        }


}
