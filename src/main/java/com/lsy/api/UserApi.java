package com.lsy.api;

import com.lsy.entity.UserEntity;
import com.lsy.server.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@Tag(name = "用户慕课", description = "描述")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @Operation(description = "登录", summary = "登录")
    public UserEntity login(@RequestParam(name = "loginName") String loginName, @RequestParam(name = "password") String password) {
        return userService.getUserInfo(loginName, password);
    }
}
