package com.lsy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户注册请求体")
public class UserRegisterQO {


    @Schema(description = "登录名")
    private String loginName;

    @Schema(description = "密码")
    private String password;
}
