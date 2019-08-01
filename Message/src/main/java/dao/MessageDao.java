package dao;

import list.Message;
import list.User;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public List<Message> findAll(){
        List<Message> messages=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        String sql ="SElECT * FROM message";
        try{
          ps=conn.prepareStatement(sql);
          resultSet =ps.executeQuery();
          while (resultSet.next()){
              Message message =new Message();
              message.setList_id(resultSet.getInt("id"));
              message.setTitle(resultSet.getNString("title"));
              message.setContent(resultSet.getString("content"));
              message.setUser_id(resultSet.getInt("use_id"));
              Timestamp creattime=resultSet.getTimestamp("ctime");
              Timestamp uptime=resultSet.getTimestamp("uptime");
              message.setCtime(creattime);
              message.setUptime(uptime);
              messages.add(message);

          }
              return messages;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return messages;
    }

    public List<Message> findByUserId(int id){
        List<Message> messages=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        String sql ="SElECT * FROM message WHERE use_id = ?";

        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                Message message =new Message();
                message.setTitle(resultSet.getNString("title"));
                message.setContent(resultSet.getString("content"));
                message.setUser_id(resultSet.getInt("use_id"));
                messages.add(message);
            }
            return messages;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return messages;
    }
      public boolean deleteMessage(int id){
          Connection conn = JdbcUtil.getConnection();
          PreparedStatement ps =null;
          ResultSet resultSet =null;
          String sql ="DELETE FROM message WHERE id=?";
          try {
           ps=conn.prepareStatement(sql);
           ps.setInt(1,id);
           int n=ps.executeUpdate();
           if(n>0){
               return true;
           }
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              JdbcUtil.close(resultSet,ps,conn);
          }
        return false;
      }
      public boolean insertMessage(String title,String content,int use_id){
          Connection conn = JdbcUtil.getConnection();
          PreparedStatement ps =null;
          ResultSet resultSet =null;
          String sql ="INSERT into message(title,content,ctime,uptime,use_id)VALUE (?,?,NOW(),NOW(),?);";
          int n=0;
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,content);
            ps.setInt(3,use_id);
            n=ps.executeUpdate();
        }
        catch (Exception e){
              e.printStackTrace();
          }finally {
              JdbcUtil.close(resultSet,ps,conn);
          }
          return n>0;
      }
      public boolean updateMessage( int i,String title,String content){
          Connection conn = JdbcUtil.getConnection();
          PreparedStatement ps =null;
          ResultSet resultSet =null;
          int n=0;
          String sql="UPDATE message SET title =?,content =?,uptime=NOW() WHERE id=?;";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1,i);
            ps.setString(2,title);
            ps.setString(3,content);
            n=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return n>0;
      }

    /**
     * 根据用户名获取留言
     * @param name
     * @return
     */
    public List<Message> findByUsername(String name){
        UserDao ud =new UserDao();
        User user=ud.findByName(name);

        List<Message> messages=new ArrayList<>();
        messages=findByUserId(user.getid());
        return messages;
    }
/*    public Message findById(int i){
        Message message =null;
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet =null;
        String sql ="SELECT * FROM message WHERE id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,i);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                message.setList_id(resultSet.getInt("id"));
                message.setTitle(resultSet.getNString("title"));
                message.setContent(resultSet.getString("content"));
                message.setUser_id(resultSet.getInt("use_id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,ps,conn);
        }
        return message;
    }*/
}
