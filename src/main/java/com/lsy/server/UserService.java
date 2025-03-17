package com.lsy.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsy.entity.UserEntity;
import com.lsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public String getUserInfoByNameAndPassword(String loginName, String password) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginName", loginName).eq("password", password);
        return userMapper.selectOne(queryWrapper).getLoginName();
    }

    public UserEntity getUserInfo(String loginName, String password) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginName", loginName).eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }

    public Page<UserEntity> testPage(String loginName, String password) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginName", loginName).eq("password", password);
        Page<UserEntity> page = new Page<>(0, 10);
        return userMapper.selectPage(page, queryWrapper);
    }

    public List<UserEntity> getUserInfos(String loginName) {
        return userMapper.getUserInfos(loginName);
    }

    public List<UserEntity> getUserInfoSByMapper(String loginName) {
        return userMapper.getUserInfoSByMapper(loginName);
    }
}
