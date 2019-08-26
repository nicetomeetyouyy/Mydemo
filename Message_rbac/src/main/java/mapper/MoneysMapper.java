package mapper;

import entity.Moneys;

import java.math.BigDecimal;

public interface MoneysMapper {
    public Moneys findMoney(int user_id);
    public void insertMoney(Moneys moneys);
    public void updateMoney(BigDecimal money, int user_id);
    public void deleteMoney(int user_id);
}
