package entity;

import java.util.Date;

public class Operation {

    private int id;
    private String user_name;
    private int user_id;
    private String ope;
    private String time;
    private Date nowtime;
    private String result;

    public Operation() {
    }

    public Operation(int id, String user_name, int user_id, String ope, String time, Date nowtime, String result) {
        this.id = id;
        this.user_name = user_name;
        this.user_id = user_id;
        this.ope = ope;
        this.time = time;
        this.nowtime = nowtime;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOpe() {
        return ope;
    }

    public void setOpe(String ope) {
        this.ope = ope;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getNowtime() {
        return nowtime;
    }

    public void setNowtime(Date nowtime) {
        this.nowtime = nowtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
