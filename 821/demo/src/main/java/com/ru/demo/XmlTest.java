package com.ru.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ru.UserDao;

public class XmlTest {
  public static void main(String[] args){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app.xml");
    UserDao userDao = (UserDao) applicationContext.getBean("userDao");
    userDao.del_user();
    System.out.println();
    userDao.add_user();
    System.out.println();
    userDao.sel_user();
    System.out.println();
    userDao.upd_user();
  }
}
