package com.lsy.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsy.entity.UserEntity;
import com.lsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity getUserInfo(String loginName, String password) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginName", loginName).eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }
}
