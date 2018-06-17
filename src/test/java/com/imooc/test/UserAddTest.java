package com.imooc.test;

import com.imooc.mapper.UserMapper;
import com.imooc.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class UserAddTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser(){
        User user = new User();
        user.setUid(96);
        user.setPassword("123");
        user.setUsername("tom");
        userMapper.insert(user);
    }
}
