package control;

import entity.Access;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.AccessService;
import services.RoleServices;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping("deleteRole")
    public String deleteRole(HttpServletRequest request){
        String rid=request.getParameter("rid");
        roleServices.deleteRole(Integer.valueOf(rid));
        roleServices.deleteAcc(Integer.valueOf(rid));
        List<Role> list =roleServices.findAll();
        request.getSession().setAttribute("roleList",list);
        return "Role_acc";
}
    @RequestMapping("updateRole")
    public String updateRole(HttpServletRequest request){
        String rid =request.getParameter("rid");
        Role role=roleServices.findById(Integer.valueOf(rid));
        request.getSession().setAttribute("Role",role);
        List<Access> access=accessService.findRole_acc(Integer.valueOf(rid));
        request.getSession().setAttribute("accList",access);
        List<Access> allAcc=accessService.findAll();
     /*   for (Access a:allAcc
             ) {
            System.out.println(allAcc.size());
            System.out.println(a.getName());
        }*/
//        for (Access a:access
//             ) {
//            System.out.println(a.getName());
//        }
        request.getSession().setAttribute("allAcc",allAcc);
        return "updateToRole";
    }
    @RequestMapping("updateToRole")
    public String updateToRole(HttpServletRequest request){
        String name = (String) request.getAttribute("rname");
        Role r = (Role) request.getSession().getAttribute("Role");

        r.setName(name);
        List<Access> list=accessService.findAll();
        int length=list.size();
        accessService.deleteAccR(r.getId());
        for(int i=0;i<length;i++){
            String role="role"+i;
            String aid=request.getParameter(role);
            if(aid!=null) {

                accessService.insertAcc(r.getId(), Integer.valueOf(aid));
            }}
        List<Role> list1 =roleServices.findAll();
        request.getSession().setAttribute("roleList",list1);
        return "Role_acc";
    }
    @RequestMapping("roleManager")
    public String roleManager(HttpServletRequest request){
        System.out.println("添加角色");
        List<Access> allAcc=accessService.findAll();
        request.getSession().setAttribute("allAcc",allAcc);
        return"addRole";
    }
    @RequestMapping("addtoRole")
    public String addRole(HttpServletRequest request){
        String name = (String) request.getParameter("rolename");
        System.out.println(name);
        roleServices.insertRole(name);
        Role r =roleServices.findRid(name);
        List<Access>list = (List<Access>) request.getSession().getAttribute("allAcc");
        int length=list.size();
        for(int i=0;i<length;i++){
            String role="role"+i;
            System.out.println(role);
            String aid=request.getParameter(role);
            System.out.println("ceshi2");
            if(aid!=null) {
                accessService.insertAcc(r.getId(), Integer.valueOf(aid));
                System.out.println("ceshi");
            }}
        System.out.println("ceshi2");
        List<Role> list1=roleServices.findAll();

        request.getSession().setAttribute("roleList",list1);
        return "Role_acc";
    }
}
