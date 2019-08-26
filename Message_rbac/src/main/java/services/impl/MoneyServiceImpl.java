package services.impl;

import entity.Bill;
import entity.Moneys;
import mapper.BillMapper;
import mapper.MoneysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.MoneyService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneysMapper moneysMapper;
    @Autowired
    private BillMapper billMapper;
    @Override

    public Moneys findMoney(int user_id) {
        return moneysMapper.findMoney(user_id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void costMoney(BigDecimal money, int addUser, int reduceUser) {
        Moneys addMoney=moneysMapper.findMoney(addUser);
        Moneys reduceMoney=moneysMapper.findMoney(reduceUser);
        BigDecimal add=addMoney.getMoney().add(money);
        BigDecimal reduce=reduceMoney.getMoney().subtract(money);
        Bill addBill=new Bill("打赏",money,addUser);
        Bill reduceBill=new Bill("消费",money,reduceUser);
        Double num=Math.random()*10;
//        System.out.println(num);
        moneysMapper.updateMoney(reduce,reduceUser);
        billMapper.insertBill(reduceBill);
        if(num>5.0){
//            System.out.println(num);
            int i=1/0;
        }
        moneysMapper.updateMoney(add,addUser);
        billMapper.insertBill(addBill);

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addMoney(BigDecimal money, int user_id) {
       Moneys moneys=moneysMapper.findMoney(user_id);
       BigDecimal newMoney=moneys.getMoney().add(money);
       Bill newBill=new Bill("充值",money,user_id);
       moneysMapper.updateMoney(newMoney,user_id);
       billMapper.insertBill(newBill);
    }
    public List<Bill> findByUser(int user_id){
        return billMapper.findByUser(user_id);
    }

}
