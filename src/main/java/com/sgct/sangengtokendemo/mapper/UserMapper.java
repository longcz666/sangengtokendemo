package com.sgct.sangengtokendemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgct.sangengtokendemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author l'c'z
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-10-07 21:22:43
* @Entity com/sgct/sangengtokendemo.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




