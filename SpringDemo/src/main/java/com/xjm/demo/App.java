package com.xjm.demo;

import com.xjm.demo.configure.configure;
import com.xjm.demo.entity.Role;
import com.xjm.demo.hello.Hello;
import com.xjm.demo.hello.HelloAdapter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        Hello hello = (Hello) applicationContext.getBean("Hello");
        hello.satHello();
        applicationContext = new FileSystemXmlApplicationContext("D:\\train_group2\\SpringDemo\\src\\main\\resources\\Spring.xml");
        Hello hello1 = (Hello) applicationContext.getBean("Hello");
        hello1.satHello();
        System.out.println(hello.toString());*/
/*        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Hello hello= (Hello) applicationContext.getBean("hello");
        System.out.println(hello.toString());
        HelloAdapter helloAdapter= (HelloAdapter) applicationContext.getBean("helloAdapter");
        helloAdapter.sayHi();*/
      /* ApplicationContext context=new AnnotationConfigApplicationContext(configure.class);
       Hello hello= (Hello) context.getBean("hello");
       hello.satHello();*/
      ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        JdbcTemplate jt= (JdbcTemplate) context.getBean("jdbcTemplate");
        List<Role> list=jt.query("select * from role",new BeanPropertyRowMapper<>(Role.class));
        for (Role r:list
             ) {
            System.out.println(r.toString());
        }
        jt.update("update role set name=?","haha");
        jt.update("insert into role values (?,?)",2,"heheh");
        jt.update("delete from role where id=?",1);
    }
}
