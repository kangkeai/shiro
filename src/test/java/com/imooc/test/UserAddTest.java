package com.imooc.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.imooc.mapper.UserMapper;
import com.imooc.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    @Test
    public void SelectUser(){
//        User user = new User();
//        user.setUid(96);
//        user.setUsername("tom");
//        user.setPassword("123");
//        User userVo = userMapper.selectOne(user);
        List<User> userList = userMapper.selectList(new EntityWrapper<User>().eq("username","tom"));
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            System.out.println("*****************************************");
            System.out.println(user.getPassword());
            System.out.println("*****************************************");
        }
    }
}
