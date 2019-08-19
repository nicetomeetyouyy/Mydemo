package entity;

public class Image {
    private int id;
    private String filename;
    private int user_id;
    private int is_used;

    public Image() {
    }

    public Image(int id, String filename, int user_id, int is_used) {
        this.id = id;
        this.filename = filename;
        this.user_id = user_id;
        this.is_used = is_used;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIs_used() {
        return is_used;
    }

    public void setIs_used(int is_used) {
        this.is_used = is_used;
    }
}
