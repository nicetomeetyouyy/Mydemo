package services;

import entity.Image;

import java.util.List;

public interface ImageService {
    public List<Image> findByUser(int user_id);
    public void insertImage(Image image);
    public void updateImage(int is_used, int id, int user_id);
    public void deleteImage(int id);
    public Image findOne(int user_id, int is_used);
}
