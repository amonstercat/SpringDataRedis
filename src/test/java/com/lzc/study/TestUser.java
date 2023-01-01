package com.lzc.study;


import com.lzc.study.service.UserService;
import com.lzc.study.service.UserServiceImpl;
import org.apache.ibatis.cache.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUser {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    public  void findAll()
    {
        Cache cache;
        /*第一次查询*/
        userServiceImpl.findAll().forEach(System.out::println);
        System.out.println("========================");
        /*第二次查询*/
        userServiceImpl.findAll().forEach(System.out::println);

    }
}
