package mapper;

import entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public void  updateUser(User user);
    public User findByname(String name);
    public void  insertUser(User user);
    public void deleteUser(int id);
}
