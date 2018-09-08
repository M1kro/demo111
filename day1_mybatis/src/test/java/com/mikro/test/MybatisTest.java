package com.mikro.test;


import com.mikro.dao.UserDao;
import com.mikro.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

//mybatis的入门案例
public class MybatisTest {
        private InputStream in;
        private SqlSession session;
        private UserDao userDao;
        @Before
        public void Before() throws IOException {
            //        1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
//          2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
//         3.使用工厂生产SqlSession对象
            session = factory.openSession();
            //4.使用SqlSession创建Dao接口的代理对象
            userDao = session.getMapper(UserDao.class);
        }
        @After
public void After() throws IOException {
    session.commit();

    //6.释放资源
            session.close();
            in.close();
}
@Test
public void  findAll(){
    List<User> all = userDao.findAll();
    for (User user : all) {
        System.out.println(user);
    }
}
//测试保存方法
        @Test
    public void Testsave(){
            User user1 = new User();
            user1.setUsername("王二");
            user1.setBirthday(new Date());
            user1.setSex("男");
            user1.setAddress("北京");
            System.out.println(user1);
            userDao.save(user1);
            System.out.println("保存成功");
            System.out.println(user1);
        }

/**
 * 测试更新操作
 */
    @Test
    public void Testupdate(){
        User user = new User();
        user.setUsername("王五");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("上海");
        userDao.update(user);
    }
    //根据名字删除User
    @Test
    public void Testdelete(){
        userDao.delete("老王");
    }
    //根据id找到User
    @Test
    public void  TestfindByid(){
        User byid = userDao.findByid(48);
        System.out.println(byid);
    }
    //模糊查询所有姓王的User
    @Test
    public void  TestfindByname(){
        List<User> byname = userDao.findByname("%王%");
        for (User user : byname) {
            System.out.println(user);
        }
    }
//查询姓王的有几个
    @Test
    public void Testtotal(){
        Integer total = userDao.total("%王%");
        System.out.println(total);
    }
}
