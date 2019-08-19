package services.impl;

import entity.Image;
import mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ImageService;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public List<Image> findByUser(int user_id) {
        return imageMapper.findByUser(user_id);
    }

    @Override
    public void insertImage(Image image) {
       imageMapper.insertImage(image);
    }

    @Override
    public void updateImage(int is_used, int id, int user_id) {
       imageMapper.updateImage(is_used,id,user_id);
    }

    @Override
    public void deleteImage(int id) {
      imageMapper.deleteImage(id);
    }

    @Override
    public Image findOne(int user_id, int is_used) {
        return imageMapper.findOne(user_id,is_used);
    }
}
