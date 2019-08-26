package entity;

import java.math.BigDecimal;

public class Moneys {
    private int id;
    private BigDecimal money;
    private  int user_id;

    public Moneys() {
    }

    public Moneys(int id, BigDecimal money, int user_id) {
        this.id = id;
        this.money = money;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
