package logger;

import annotation.Log;
import entity.Operation;
import entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.OperationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Aspect
@Component
public class logAspect {
    @Autowired
    HttpServletRequest request;
   @Autowired
    private OperationService operationService;
   @Autowired
   private HttpServletResponse response;
   /* private Operation operation;
    private long start;*/
/* @Autowired
 private OperationService operationService;*/

  @Pointcut("execution(* control.*.*(..))&&!execution(* control.IndexControl.view(..))&&!" +
          "execution(* control.UserControl.LogginOut(..))")
    public void loga(){}
   @Before("loga()")
    public void before(JoinPoint joinPoint){
      System.out.println("日志开始咯");
//      User user = (User) request.getSession().getAttribute("User");
//      String name =user.getUser_name();
//      int id=user.getId();
//      System.out.println(id+name);
//      start=System.currentTimeMillis();
    }
    @AfterReturning("loga()")
    public  void after(JoinPoint joinPoint) throws ServletException, IOException {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        Log log=method.getAnnotation(Log.class);
//        if(log==null) {
//            return;
//        }
//      User user = (User) request.getSession().getAttribute("User");
//
//      Operation operation1=insertOpe(user,operation,"成功");
//      operation1.setOpe(log.operationName());
//      operationService.insertOperation(operation1);
      System.out.println("记录结束");
//      Operation operation= (Operation) request.getAttribute("operation");
//      if("失败".equals(operation.getResult())){
//          request.getRequestDispatcher("melist.jsp").forward(request,response);
//      }
    }
    @Around("loga()")
    public Object arroud(ProceedingJoinPoint joinPoint) throws Throwable {
        Operation operation=new Operation();
         long start =System.currentTimeMillis();
        Object result= joinPoint.proceed();
        long time =System.currentTimeMillis()-start;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log=method.getAnnotation(Log.class);
        operation.setTime(time+"ms");
        request.getSession().setAttribute("operation",operation);
        if(log==null) {
            return result;
        }

        User user = (User) request.getSession().getAttribute("User");

        if(user==null){
            return result;
        }

        operation.setOpe(log.operationName());
        Operation operation1=insertOpe(user,operation,"成功");
        operation1.setOpe(log.operationName());
        operationService.insertOperation(operation);
        return result;
    }
    @AfterThrowing("loga()")
    public void throwOpe(JoinPoint joinPoint) throws ServletException, IOException {
        System.out.println("我异常啦");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log=method.getAnnotation(Log.class);
        if(log==null) {
            return;
        }
        User user=new User();
        User user1 = (User) request.getSession().getAttribute("User");

        if(user1==null){
             String name= (String) request.getSession().getAttribute("username");
             user.setUser_name(name);
        }else {
            user=user1;
        }
        System.out.println(user.getUser_name());
        Operation operation=new Operation();
        Operation operation1= (Operation) request.getSession().getAttribute("operation");
        if(operation1!=null){
            operation =operation1;
        }
        Operation operation2=insertOpe(user,operation,"失败");
        operation2.setOpe(log.operationName());
        operationService.insertOperation(operation2);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
    public Operation insertOpe(User user,Operation operation,String result){
        String name =user.getUser_name();
        int id=user.getId();
        System.out.println(id+name);
        operation.setUser_name(name);
        System.out.println(name);
        operation.setUser_id(id);
        operation.setResult(result);
        return operation;
    }
}
