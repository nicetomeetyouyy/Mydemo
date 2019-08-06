package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.message.callback.PrivateKeyCallback;
import java.util.Collection;
import java.util.Map;

@Controller

public class IndexControl {

    @RequestMapping("/")
    public String view(){
        return "index";
    }
}
