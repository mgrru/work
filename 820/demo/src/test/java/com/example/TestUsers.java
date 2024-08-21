package com.example;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.util.Mybatis;

public class TestUsers {
  @Test
  public void test_sel_user() {
    SqlSession sql_session = Mybatis.getSession();
    UserMapper user_mapper = sql_session.getMapper(UserMapper.class);
    User user = user_mapper.sel_user_by_id(1);
    System.out.println(user);
  }
}
