package com.thinkingcao.encrypt.controller;

import com.thinkingcao.encrypt.constant.Constants;
import com.thinkingcao.encrypt.entity.LoginUser;
import com.thinkingcao.encrypt.result.ApiResult;
import com.thinkingcao.encrypt.utils.JwtUtil;
import com.thinkingcao.encrypt.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-09 18:52
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Lazy
    @Autowired(required = false)
    private RedisUtils redisUtil;

    @PostMapping(value = "/login")
    public ApiResult login(String username, String passward) {

        //TODO: 数据库查询登录用户操作
        //假设登陆成功
        LoginUser loginUser = new LoginUser(username, passward);
        //生成token
        String token = JwtUtil.generateToken(username, Constants.SALT, Duration.ofSeconds(Constants.JWT_EXPIRE_SECOND));
        log.debug("token:{}", token);
        //将token存进redis
        redisUtil.set(token,loginUser,Constants.TOKEN_EXPIRE_SECOND);
        //返回成功
        return ApiResult.succee(loginUser, "登录成功");
    }
}
