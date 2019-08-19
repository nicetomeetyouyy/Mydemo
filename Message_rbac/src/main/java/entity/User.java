package entity;

import java.util.List;

public class User {
    private int id;
    private String user_name;
    private String pwd;
    private String email;
    private String phone;
    private int rid;
    private int gid;
    private List<Access> accesses;
    private Role role;
    public User(int id, String user_name, String pwd, String email, String phone, int rid, int gid, Role role) {
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.rid = rid;
        this.gid = gid;
        this.role=role;
    }

    public User() {
    }

    public User(String user_name, String pwd, String email, String phone, int rid, int gid) {
        this.user_name = user_name;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.rid = rid;
        this.gid = gid;
    }

    public User(int id, String user_name, String pwd, String email, String phone, int rid, int gid) {
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.rid = rid;
        this.gid = gid;
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

    public void setUser_name(String name) {
        this.user_name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public List<Access> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
