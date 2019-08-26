package mapper;

import entity.Bill;

import java.util.List;

public interface BillMapper {
    public List<Bill> findAll();
    public List<Bill> findByUser(int user_id);
    public void insertBill(Bill bill);
}
