package com.lsy.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsy.entity.UserEntity;
import com.lsy.server.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Tag(name = "用户", description = "描述")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @Operation(description = "登录", summary = "登录")
    public UserEntity login(@RequestParam(name = "loginName") String loginName, @RequestParam(name = "password") String password) {
        return userService.getUserInfo(loginName, password);
    }

    @GetMapping("/page")
    @Operation(description = "测试分页", summary = "测试分页")
    public Page<UserEntity> testPage(@RequestParam(name = "loginName") String loginName, @RequestParam(name = "password") String password) {
        return userService.testPage(loginName, password);
    }


    @GetMapping("/definy")
    @Operation(description = "测试自定义")
    public List<UserEntity> userDefiny(@RequestParam(name = "loginName") String loginName){
        return userService.getUserInfos(loginName);
    }

    @GetMapping("/testMap")
    @Operation(description = "测试mapper查询")
    public List<UserEntity> getUserInfoSByMapper(@RequestParam(name = "loginName") String loginName){
        return userService.getUserInfoSByMapper(loginName);
    }
 }
