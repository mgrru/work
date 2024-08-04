package com.ru.dao;

import java.util.List;

import com.ru.entity.Account;

public interface AccountDao {
  void add(Account account);

  void del(Account account);

  void update(Account account);

  List<Account> get_all();

  Account get_by_id(int id);
}
