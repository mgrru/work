package com.example.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
  private static SqlSessionFactory sqlSessionFactory = null;
  // 初始化SqlSessionFactory对象
  static {
    try {
      Reader reader = Resources.getResourceAsReader("mybatis.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 获取SqlSession对象的静态方法
  public static SqlSession getSession() {
    return sqlSessionFactory.openSession();
  }
}
