package com.ru.service.impl;

import com.ru.dao.UserDao;
import com.ru.service.UserService;

public class UserServiceImpl implements UserService {
  UserDao user_dao;

  public void set_user_dao(UserDao user_dao) {
    this.user_dao = user_dao;
  }

  @Override
  public boolean login(String name, String password) {
    return user_dao.login(name, password);
  }

}
