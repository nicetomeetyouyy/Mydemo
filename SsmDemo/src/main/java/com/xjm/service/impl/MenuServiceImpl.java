package com.xjm.service.impl;


import com.xjm.mapper.MenuMapper;
import com.xjm.pojo.Menu;
import com.xjm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findMenu(int id) {
        return menuMapper.findMenu(id);
    }
}
