package com.lzc.study.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        //创建redisTemplate对象
           RedisTemplate<Object,Object>  redisTemplate=new RedisTemplate<>();
        //设置连接工厂
         redisTemplate.setConnectionFactory(redisConnectionFactory);
        //创建json序列化工具
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
       //设置key序列化
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        //设置value序列化
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
       return  redisTemplate;
    }
}
