package services.impl;

import entity.Role;
import mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.RoleServices;
import services.UserService;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleServices {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;
    @Override
    public Role findById(int id) {
        return roleMapper.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void deleteRole(int rid) {
        userService.deleteUserRid(rid);
        roleMapper.deleteRole(rid);
    }
}
