package services.impl;

import annotation.Log;
import entity.Moneys;
import entity.User;
import mapper.MoneysMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service("userServices")
public class UserServiceImp implements services.UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MoneysMapper moneysMapper;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertUser(User user) {

            userMapper.insertUser(user);
//            System.out.println("添加用户"+user.getUser_name());
            User user1=userMapper.findByname(user.getUser_name());
            Moneys moneys=new Moneys();
            moneys.setMoney(BigDecimal.valueOf(0));
            moneys.setUser_id(user1.getId());
            moneysMapper.insertMoney(moneys);


    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUser(int id){

        userMapper.deleteUser(id);
        moneysMapper.deleteMoney(id);
    }
    @Override
    public User findLogin(String name, String pwd) {
        return userMapper.findLogin(name,pwd);
    }

    @Override
    public void deleteUserRid(int rid) {
        userMapper.deleteUserRid(rid);
    }

    @Override
    public List<User> findByGid(int gid) {
        return userMapper.findByGid(gid);
    }
}
