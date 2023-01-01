package com.lzc.study.service;


import com.lzc.study.entity.User;
import com.lzc.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements  UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return  userMapper.findAll();
    }
}
