import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import services.UserService;

import java.util.List;

public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public  void test1(){

        User user=userService.findByname("张三") ;
        System.out.println(user.getEmail());
    }
}
