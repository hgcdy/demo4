package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.UserEntity;
import cn.netinnet.demo4.mapper.UserMapper;
import cn.netinnet.demo4.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //登录验证
    @Override
    public UserEntity getUser(String userCode, String userPassword) {
        return userMapper.getUser(userCode, userPassword);
    }
}
