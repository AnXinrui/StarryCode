package com.starrycode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starrycode.common.BusinessException;
import com.starrycode.common.ErrorCode;
import com.starrycode.model.VO.UserVO;
import com.starrycode.model.domain.User;
import com.starrycode.service.UserService;
import com.starrycode.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
* @author axr
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    private static final String SALT = "STARRYCODE";

    @Override
    public Long register(String userName, String userPassword, String confirmPassword) {
        if (StringUtils.isAnyBlank(userName, userPassword, confirmPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码不能为空!");
        }
        if (userName.length() < 2) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名长度过短!");
        } else if (userName.length() > 25) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名长度过长!");
        }
        if (!userPassword.equals(confirmPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入的密码不一致!");
        }
        if (userPassword.length() < 6 || userPassword.length() > 25) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码长度应为6~25位!");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        long count = this.count(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "注册失败，当前用户名已存在!");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(encryptPassword);
        boolean save = this.save(user);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return user.getId();
    }

    @Override
    public String login(String userName, String userPassword, HttpSession session) {
        if (StringUtils.isAnyBlank(userName, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码不能为空!");
        }
        if (userName.length() < 2 || userName.length() > 25 || userPassword.length() < 6 || userPassword.length() > 25) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误!");
        }
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        User user = this.getOne(new QueryWrapper<User>().eq("userName", userName).eq("userPassword", encryptPassword));
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误!");
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        session.setAttribute("user", userVO);
        return "";
    }
}




