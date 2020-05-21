package com.thinkingcao.encrypt.service;

import com.thinkingcao.encrypt.entity.LoginUser;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-18 13:59
 */
@Service
public class LoginUserService {

    public LoginUser getLoginUserByUsername(){
        LoginUser loginUser = new LoginUser();
        loginUser.setName("zhangsan");
        loginUser.setPassward("111111");
        return loginUser;
    }
}
