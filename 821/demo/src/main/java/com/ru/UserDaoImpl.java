package com.ru;

public class UserDaoImpl implements UserDao{

  @Override
  public void add_user() {
    System.out.println("添加用户");
  }

  @Override
  public void del_user() {
    System.out.println("删除用户");
  }

  @Override
  public void sel_user() {
    System.out.println("查询用户");
  }

  @Override
  public void upd_user() {
    System.out.println("更新用户");
  }
  
}
