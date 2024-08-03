package com.ru.dao;

import java.util.List;

import com.ru.entity.Account;

public interface AccountDao {
  void save(Account account);

  void del(Account account);

  void update(Account account);

  List<Account> get_all();
}
