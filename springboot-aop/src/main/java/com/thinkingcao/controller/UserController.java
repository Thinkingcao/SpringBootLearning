package com.thinkingcao.controller;

import com.thinkingcao.annotation.InsertLog;
import com.thinkingcao.entity.User;
import com.thinkingcao.result.ApiResult;
import com.thinkingcao.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService mUserService;

    @PostMapping("/add")
    @InsertLog(logStr = "打印微信日志")
    public ApiResult add(User user) throws NotFoundException {
        return mUserService.add(user);
    }
}
