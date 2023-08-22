package com.hqu.controller;
import com.hqu.pojo.Result;
import com.hqu.pojo.User;
import com.hqu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("用户注册：{}",user);
        userService.insert(user);
        return Result.success();
    }
}
