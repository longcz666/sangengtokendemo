package com.sgct.sangengtokendemo.controller;

import com.sgct.sangengtokendemo.domain.ResponseResult;
import com.sgct.sangengtokendemo.domain.User;
import com.sgct.sangengtokendemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){

       return loginService.login(user);
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
