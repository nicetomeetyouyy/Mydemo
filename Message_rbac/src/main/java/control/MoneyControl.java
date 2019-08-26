package control;

import entity.Bill;
import entity.Moneys;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.MoneyService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class MoneyControl {
    @Autowired
    private MoneyService moneyService;
    @RequestMapping("addMoney")
    public String addMoney(HttpServletRequest request){
        Moneys money= (Moneys) request.getSession().getAttribute("money");
        int user_id=money.getUser_id();
         String addMoney=request.getParameter("addMoney");
         moneyService.addMoney(new BigDecimal(addMoney),user_id);
         return "redirect:updateUser";
    }
    @RequestMapping("costMoney")
    public String costMoney(Model model,HttpServletRequest request){
        String adduser=request.getParameter("addUser");
        User user= (User) request.getSession().getAttribute("User");
        int id=user.getId();
        int addUser=Integer.valueOf(adduser);
        Moneys moneys=moneyService.findMoney(id);
        model.addAttribute("addUser",addUser);
        model.addAttribute("money",moneys);
        return "costMoney";
 }
   @RequestMapping("costToMoney")
    public String costToMoney(HttpServletRequest request){
        String cost=request.getParameter("costMoney");
        int addUser= (int) request.getSession().getAttribute("addUser");
       User user= (User) request.getSession().getAttribute("User");
        int reduceUser=user.getId();
        try{
            moneyService.costMoney(new BigDecimal(cost),addUser,reduceUser);
        }catch (Exception e){
          return "redirect:error";
        }
        return "redirect:melist";
   }
   @RequestMapping("billList")
    public String billList(Model model,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("User");
        List<Bill> list=moneyService.findByUser(user.getId());
        model.addAttribute("bill",list);
        return "billList";
   }
}
