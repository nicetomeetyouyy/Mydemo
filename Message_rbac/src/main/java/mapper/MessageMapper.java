package mapper;

import entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    public List<Message> findAll();
    public List<Message> findByuse_id(int use_id);
    public void deleteMessage(int id);
    public void insertMessage(Message message);
    public void updateMessage(Message message);
    public Message findById(int id);
    public List<Message> findGp(int gid);
}
