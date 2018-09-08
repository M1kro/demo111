package com.mikro.dao;

import com.mikro.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //查询所有
//   @Select("select * from user")// 注解配置
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(String name);
    User findByid(Integer id);
    List<User> findByname(String username);
    Integer total(String username);
}