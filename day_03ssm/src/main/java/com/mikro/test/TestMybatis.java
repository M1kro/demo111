package com.mikro.test;

import com.mikro.dao.AccountDao;
import com.mikro.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    //测试查询数据库
    public void run1() throws IOException {
        //加载Mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlsessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建Sqlsession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }




    //测试保存数据库
    @Test
    public void run2() throws IOException {
        //加载Mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlsessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建Sqlsession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setId(3);
        account.setName("miaomikro");
        account.setMoney(4000d);
        //保存
        dao.saveAccount(account);
        //增删改 需要：提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
