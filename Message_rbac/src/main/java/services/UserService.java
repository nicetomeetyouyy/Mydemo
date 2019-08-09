package services;

import entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void  updateUser(User user);
    public User findByname(String name);
    public void  insertUser(User user);
    public void  deleteUser(int id);
    public User findLogin(String name, String pwd);
    public void  deleteUserRid(int rid);
    public List<User> findByGid(int gid);

}
