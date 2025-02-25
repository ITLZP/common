package com.lsy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value = "user_td")
@Data
public class UserEntity {
    private Integer id;

    private String loginName;

    private String password;

    private String name;

    private LocalDateTime createTime;

    private String createName;

    private LocalDateTime updateTime;

    private String updateName;

    private String isValid;

    private String img;
}
