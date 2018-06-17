package com.imooc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.imooc.mapper.UserMapper;
import com.imooc.service.IUserService;
import com.imooc.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

}
