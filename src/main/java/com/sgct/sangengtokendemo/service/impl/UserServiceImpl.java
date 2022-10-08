package com.sgct.sangengtokendemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.sgct.sangengtokendemo.domain.User;
import com.sgct.sangengtokendemo.mapper.UserMapper;
import com.sgct.sangengtokendemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author l'c'z
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2022-10-07 21:22:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




