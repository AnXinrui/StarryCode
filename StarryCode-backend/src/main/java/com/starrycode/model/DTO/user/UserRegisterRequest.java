package com.starrycode.model.DTO.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 注册请求体
 * @author axr
 */
@Data
public class UserRegisterRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String userName;
    private String userPassword;
    private String confirmPassword;
}
