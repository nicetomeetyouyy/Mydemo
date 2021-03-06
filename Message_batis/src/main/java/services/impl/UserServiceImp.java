package services.impl;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements services.UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser( user);
    }

    @Override
    public User findByname(String name) {
        return userMapper.findByname(name);
    }

    @Override
    public void insertUser(User user) {
       userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
