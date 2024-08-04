package com.ru.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ru.dao.AccountDao;
import com.ru.dao.BaseDao;
import com.ru.entity.Account;
import com.ru.entity.Master;

public class MasterDaoImpl extends BaseDao implements AccountDao {
  private static final Logger logger = LogManager.getLogger(PetDaoImpl.class);

  @Override
  public void add(Account account) {
    String sql = "insert into master values(?,?,?,?)";
    Object[] params = {
        account.get_id(),
        account.get_login_name(),
        account.get_login_pass(),
        account.get_balance()
    };

    try {
      executeUpdate(sql, params);
      logger.info("添加主人");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void del(Account account) {
    String sql = "delete from master where id=?";
    Object[] params = { account.get_id() };
    try {
      executeUpdate(sql, params);
      logger.info("删除主人");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void update(Account account) {
    String sql = "update master set "
        + "login_name=?"
        + "login_pass=?"
        + "balance=?"
        + " where id=?";
    Object[] params = {
        account.get_login_name(),
        account.get_login_pass(),
        account.get_balance(),
        account.get_id(),
    };

    try {
      executeUpdate(sql, params);
      logger.info("删除主人");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public List<Account> get_all() {
    String sql = "select * from master";
    List<Account> result = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      while (rs.next()) {
        Account account = new Master();
        account.set_id(rs.getInt(0));
        account.set_login_name(rs.getString(1));
        account.set_login_pass(rs.getString(2));
        account.set_balance(rs.getInt(3));
        result.add(account);
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return result;
  }

  @Override
  public Account get_by_id(int id) {
    String sql = "select * from master where id=?";
    Account account = new Master();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      rs = stmt.executeQuery();
      while (rs.next()) {
        account.set_id(rs.getInt(0));
        account.set_login_name(rs.getString(1));
        account.set_login_pass(rs.getString(2));
        account.set_balance(rs.getInt(3));
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return account;
  }

}
