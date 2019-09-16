package com.xjm.mapper;

import com.xjm.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    public List<Menu> findMenu(int id);
}
