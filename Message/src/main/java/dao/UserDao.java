package dao;

import list.User;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    /**
     * 查找所有用户信息
     * @return list的用户信息
     */
    public List<User> findALL(){
        List<User> users=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        String sql="SELECT * FROM users";
        try {
            ps=conn.prepareStatement(sql);
            resultSet =ps.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setid(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("pwd"));
                user.setEmail(resultSet.getString("email"));
                user.setPhnumber(resultSet.getString("phone"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return users;
    }

    /**
     * 修改用户信息
     * @param name
     * @param password
     * @param emain
     * @param phone
     * @return Boolean
     */
    public boolean updateUser(int id,String name,String password,String emain,String phone){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        int n=0;
        String sql ="UPDATE users SET user_name=?,pwd=?,email=?,phone=? WHERE id= ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,emain);
            ps.setString(4,phone);
            ps.setInt(5,id);
            n=ps.executeUpdate();
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          JdbcUtil.close(resultSet,ps,conn);
      }
        return n>0;
    }

    /**
     * 查找某位用户信息
     * @param name
     * @return
     */
    public User findByName(String name){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        User user=new User();
        String sql ="SELECT * FROM users WHERE user_name =?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                user.setid(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("pwd"));
                user.setEmail(resultSet.getString("email"));
                user.setPhnumber(resultSet.getString("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return user;
    }
    public boolean InsertUser(String name,String password,String email,String phone){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        int n=0;
        String sql ="INSERT INTO users(user_name,pwd,email,phone)VALUES (?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,phone);
            n=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return n>0;
    }

}
