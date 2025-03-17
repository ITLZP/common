package com.lsy.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsy.dto.UserRegisterQO;
import com.lsy.entity.UserEntity;
import com.lsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Collection<? extends GrantedAuthority> authorities;

    //每次请求都会查询数据中的用户建议后期使用redis以提高查询效率
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("loginName", username));
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        //后面有角色权限控制时需要在这里加上角色权限控制
        return new org.springframework.security.core.userdetails.User(
                userEntity.getLoginName(),
                userEntity.getPassword(),
                authorities ==null ? Collections.emptyList() : authorities
        );
    }

    public void userRegister(UserRegisterQO userRegisterQO) {
        UserEntity userEntity = UserEntity.builder()
                .loginName(userRegisterQO.getLoginName())
                .password(passwordEncoder.encode(userRegisterQO.getPassword()))
                .updateTime(LocalDateTime.now())
                .isValid("1")
                .build();
        userMapper.insert(userEntity);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String paw =passwordEncoder1.encode("abc123456");
        boolean isMatch = passwordEncoder1.matches("abc123456", paw); // 验证密码
        System.out.println("Password Match: " + isMatch);
        System.out.println(paw);
    }
}
