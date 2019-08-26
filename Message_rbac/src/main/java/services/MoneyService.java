package services;

import entity.Bill;
import entity.Moneys;

import java.math.BigDecimal;
import java.util.List;

public interface MoneyService {
    public Moneys findMoney(int user_id);
    public void costMoney(BigDecimal money, int addUser, int reduceUser);
    public void addMoney(BigDecimal money, int user_id);
    public List<Bill> findByUser(int user_id);
}
