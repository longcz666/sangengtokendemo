package com.sgct.sangengtokendemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgct.sangengtokendemo.domain.Menu;
import com.sgct.sangengtokendemo.mapper.MenuMapper;
import com.sgct.sangengtokendemo.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
