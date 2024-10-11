package com.starrycode.controller;

import com.starrycode.common.Result;
import com.starrycode.common.ResultUtils;
import com.starrycode.model.DTO.user.UserLoginRequest;
import com.starrycode.model.DTO.user.UserRegisterRequest;
import com.starrycode.model.VO.UserVO;
import com.starrycode.model.domain.User;
import com.starrycode.service.UserService;
import com.starrycode.utils.UserHolder;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    /**
     * 用户注册
     * @param userRegisterRequest 用户注册请求体
     * @return 用户 id
     */
    @PostMapping("/register")
    public Result<Long> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        String userName = userRegisterRequest.getUserName();
        String userPassword = userRegisterRequest.getUserPassword();
        String confirmPassword = userRegisterRequest.getConfirmPassword();
        Long result = userService.register(userName, userPassword, confirmPassword);
        return ResultUtils.success(result);
    }

    /**
     * 用户登录
     * @param userLoginRequest 用户登录请求体
     * @return token
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginRequest userLoginRequest, HttpSession session) {
        String userName = userLoginRequest.getUserName();
        String userPassword = userLoginRequest.getUserPassword();
        String result = userService.login(userName, userPassword, session);
        return ResultUtils.success(result);
    }

    /**
     * 获取当前登录用户信息
     */
    @PostMapping("/current")
    public Result<UserVO> getCurrentUser() {
        UserVO user = UserHolder.getUser();
        return ResultUtils.success(user);
    }

    /**
     * 登出
     * @param session HttpSession
     */
    @PostMapping("/logout")
    public Result<?> logout(HttpSession session) {
        session.removeAttribute("user");
        return ResultUtils.success();
    }
}
