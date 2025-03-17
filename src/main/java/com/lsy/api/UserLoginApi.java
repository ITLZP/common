package com.lsy.api;

import com.lsy.dto.UserRegisterQO;
import com.lsy.entity.UserEntity;
import com.lsy.server.UserAuthService;
import com.lsy.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "用户模块", description = "用户模块")
public class UserLoginApi {

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/user/login")
    @Operation(description = "用户登录")
    public String userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = userAuthService.loadUserByUsername(username);
        final String token = jwtUtil.generateToken(userDetails);
        return token;
    }

    @PostMapping("/regist/user")
    @Operation(description = "用户注册")
    public void registUser(@RequestBody UserRegisterQO userRegisterQO) {
        userAuthService.userRegister(userRegisterQO);
    }
}
