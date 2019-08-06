package entity;

import java.util.Date;

public class Message {
    private int id;
    private String title;
    private String content;
    private Date ctime;
    private  Date uptime;
    private int use_id;

    public Message() {
    }

    public Message(int id, String title, String content, Date ctime, Date uptime, int use_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ctime = ctime;
        this.uptime = uptime;
        this.use_id = use_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }
}
