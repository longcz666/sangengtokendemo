package com.sgct.sangengtokendemo.service.impl;

import com.sgct.sangengtokendemo.domain.LoginUser;
import com.sgct.sangengtokendemo.domain.ResponseResult;
import com.sgct.sangengtokendemo.domain.User;
import com.sgct.sangengtokendemo.service.LoginService;
import com.sgct.sangengtokendemo.utils.JwtUtil;
import com.sgct.sangengtokendemo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败！");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", jwt);
        redisCache.setCacheObject("login:" + userId, loginUser);
        return new ResponseResult(200,"登陆成功！",hashMap);

    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户数据
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult(200,"注销成功");
    }
}
