package com.sgct.sangengtokendemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sgct.sangengtokendemo.domain.LoginUser;
import com.sgct.sangengtokendemo.domain.User;
import com.sgct.sangengtokendemo.mapper.MenuMapper;
import com.sgct.sangengtokendemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> ulqw = new LambdaQueryWrapper<>();
        ulqw.eq(User::getUserName, s);
        User user = userMapper.selectOne(ulqw);

        if (Objects.isNull(user)) {
            throw new RuntimeException("User not found");
        }
        //查询对应的权限信息
        List<String> permsByUserId = menuMapper.selectPermsByUserId(user.getId());

        //把查询到的用户信息封装成UserDetails返回
        return new LoginUser(user,permsByUserId);
    }
}
