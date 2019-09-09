package com.xjm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class InsertTest {
    public static void main(String[] args) throws Exception  {

        InputStream inputStream= Resources.getResourceAsStream("src/MybatisDemo.iml");

        SqlSessionFactory ddf =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session= ddf.openSession();
        User user =new User(1,"sd","44","2141","19412464273");
        session.insert("userMapper",user);
        session.commit();
        session.close();
    }
}
