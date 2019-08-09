package services.impl;

import entity.Message;
import entity.User;
import mapper.MessageMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MessageService;

import java.util.List;

@Service
public class MssageServiceImp implements MessageService {
    @Autowired
    private MessageMapper mapper;
    @Override
    public List<Message> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Message> findByuse_id(int use_id) {
        return mapper.findByuse_id(use_id);
    }

    @Override
    public void deleteMessage(int id) {
        mapper.deleteMessage(id);
    }

    @Override
    public void insertMessage(Message message) {
       mapper.insertMessage(message);
    }

    @Override
    public void updateMessage(Message message) {
        mapper.updateMessage(message);
    }

    @Override
    public Message findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public List<Message> findGp(int gid) {
        return mapper.findGp(gid);
    }
}
