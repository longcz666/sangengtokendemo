package com.sgct.sangengtokendemo;

import com.sgct.sangengtokendemo.domain.User;
import com.sgct.sangengtokendemo.mapper.MenuMapper;
import com.sgct.sangengtokendemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SangengtokendemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void test() {
        String encode = passwordEncoder.encode("1234");
        passwordEncoder.upgradeEncoding(encode);
        System.out.println(encode);
    }

    @Test
    void test2() {
        boolean matches = passwordEncoder.matches("1234", "$2a$10$x9nZCfwJR73tBgdqa/8DTuIuVgLv.JG2SQ5KEEPXL3LyhmqzjZ82C");
        System.out.println(matches);
    }

    @Test
    void test3() {
        List<String> list = menuMapper.selectPermsByUserId(3L);
        list.forEach(System.out::println);
    }

}
