package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private int id;
    private String type;
    private BigDecimal amount;
    private Date time;
    private int user_id;

    public Bill() {
    }

    public Bill(String type, BigDecimal amount, int user_id) {
        this.type = type;
        this.amount = amount;
        this.user_id = user_id;
    }

    public Bill(int id, String type, BigDecimal amount, Date time, int user_id) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
