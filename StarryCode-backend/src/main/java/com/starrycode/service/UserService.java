package com.starrycode.service;

import com.starrycode.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpSession;

/**
* @author axr
*/
public interface UserService extends IService<User> {

    Long register(String userName, String userPassword, String confirmPassword);

    String login(String userName, String userPassword, HttpSession session);
}
