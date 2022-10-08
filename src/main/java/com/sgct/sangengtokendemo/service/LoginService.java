package com.sgct.sangengtokendemo.service;

import com.sgct.sangengtokendemo.domain.ResponseResult;
import com.sgct.sangengtokendemo.domain.User;

public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();

}
