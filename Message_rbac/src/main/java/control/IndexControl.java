package control;

import entity.Access;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.AccessService;
import services.RoleServices;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller

public class IndexControl {
    @Autowired
    private RoleServices roleServices;
    @Autowired
    private AccessService accessService;
    @RequestMapping("/")
    public String view(){
        return "index";
    }
    @RequestMapping("to_acc")
    public String to_Acc(HttpServletRequest request){
        List<Role> list =roleServices.findAll();
        request.getSession().setAttribute("roleList",list);
        return "Role_acc";
    }
    @RequestMapping("roleManager")
    public String roleManager(){
        return null;
    }

    @RequestMapping("deleteRole")
    public String deleteRole(HttpServletRequest request){
        String rid=request.getParameter("rid");
        roleServices.deleteRole(Integer.valueOf(rid));
        List<Role> list =roleServices.findAll();
        request.getSession().setAttribute("roleList",list);
        return "Role_acc";
}
    @RequestMapping("updateRole")
    public String updateRole(HttpServletRequest request){
        String rid =request.getParameter("rid");
        List<Access> access=accessService.findRole_acc(Integer.valueOf(rid));
        request.getSession().setAttribute("accList",access);
        List<Access> allAcc=accessService.findAll();
        request.getSession().setAttribute("allAcc",allAcc);
        return "updateToRole";
    }
    @RequestMapping("updateToRole")
    public String updateToRole(HttpServletRequest request){
        return null;
    }
}
