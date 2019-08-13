package mapper;

import entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    public List<User> findAll();
    public void  updateUser(User user);
    public User findByname(String name);
    public void insertUser(User user);
    public void deleteUser(int id);
    public User findLogin(String name, String pwd);
    public void deleteUserRid(int rid);
    public List<User> findByGid(int gid);
}
