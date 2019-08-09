package services;

import entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> findAll();
    public List<Message> findByuse_id(int use_id);
    public void deleteMessage(int id);
    public void insertMessage(Message message);
    public void updateMessage(Message message);
    public Message findById(int id);
    public List<Message> findGp(int gid);
}
