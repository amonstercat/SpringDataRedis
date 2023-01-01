package com.lzc.study.cache;

import com.lzc.study.util.ApplicationContextUtils;
import lombok.val;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisCache implements Cache {

    private   final String  id;

    public RedisCache(String id) {
        System.out.println(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    //缓存中放值  ApplicationContext context.getbean("redisTemplate")
    @Override
    public void putObject(Object key, Object value) {
        //通过ApplicationContextUtils工具类来获取redisTemplate
        RedisTemplate redistTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redistTemplate.setHashKeySerializer(new StringRedisSerializer());
        redistTemplate.setKeySerializer(new StringRedisSerializer());
        //使用redishash类型做为缓存存储模型  key-hashkey-value
        redistTemplate.opsForHash().put(id.toString(),key.toString(),value);
    }
   //缓存中取值
    @Override
    public Object getObject(Object key) {
        RedisTemplate redistTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redistTemplate.setHashKeySerializer(new StringRedisSerializer());
        redistTemplate.setKeySerializer(new StringRedisSerializer());
        //根据key从redis的hash类型中获取数据
        return  redistTemplate.opsForHash().get(id.toString(),key.toString());

    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redistTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redistTemplate.setHashKeySerializer(new StringRedisSerializer());
        redistTemplate.setKeySerializer(new StringRedisSerializer());
        redistTemplate.delete(id.toString());    //清空缓存
    }

    @Override  //用来获取缓存数量
    public int getSize() {
        RedisTemplate redistTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redistTemplate.setHashKeySerializer(new StringRedisSerializer());
        redistTemplate.setKeySerializer(new StringRedisSerializer());
        return redistTemplate.opsForHash().size(id.toString()).intValue();
    }
}
