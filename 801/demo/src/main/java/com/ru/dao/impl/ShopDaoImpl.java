package com.ru.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ru.dao.AccountDao;
import com.ru.dao.MysqlDao;
import com.ru.entity.Account;

public class ShopDaoImpl extends MysqlDao implements AccountDao {
  private static final Logger logger = LogManager.getLogger(PetDaoImpl.class);

  @Override
  public void save(Account account) {
    String sql = "insert into shop values(?,?,?,?)";
    Object[] params = {
        account.get_id(),
        account.get_login_name(),
        account.get_login_pass(),
        account.get_balance()
    };

    try {
      executeUpdate(sql, params);
      logger.info("添加商店");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void del(Account account) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'del'");
  }

  @Override
  public void update(Account account) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public List<Account> get_all() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get_all'");
  }

}
