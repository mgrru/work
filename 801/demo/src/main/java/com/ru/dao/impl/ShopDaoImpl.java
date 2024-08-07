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
import com.ru.entity.Shop;

public class ShopDaoImpl extends BaseDao implements AccountDao {
  private static final Logger logger = LogManager.getLogger(ShopDaoImpl.class);

  @Override
  public void add(Account account) {
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
    String sql = "delete from shop where id=?";
    Object[] params = { account.get_id() };
    try {
      executeUpdate(sql, params);
      logger.info("删除商店");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void update(Account account) {
    String sql = "update shop set "
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
      logger.info("删除商店");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public List<Account> get_all() {
    String sql = "select * from shop";
    List<Account> result = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      while (rs.next()) {
        Account account = new Shop();
        account.set_id(rs.getInt(1));
        account.set_login_name(rs.getString(2));
        account.set_login_pass(rs.getString(3));
        account.set_balance(rs.getInt(4));
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
    String sql = "select * from shop where id=?";
    Account account = new Shop();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      rs = stmt.executeQuery();
      while (rs.next()) {
        account.set_id(rs.getInt(1));
        account.set_login_name(rs.getString(2));
        account.set_login_pass(rs.getString(3));
        account.set_balance(rs.getInt(4));
      }
    } catch (Exception e) {
      logger.error("get_by_id出错"+e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return account;
  }

  @Override
  public Account get_by_login_name(String login_name) {
    String sql = "select * from shop where login_name=?";
    Account account = new Shop();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, login_name);
      rs = stmt.executeQuery();
      while (rs.next()) {
        account.set_id(rs.getInt(1));
        account.set_login_name(rs.getString(2));
        account.set_login_pass(rs.getString(3));
        account.set_balance(rs.getInt(4));
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return account;
  }

}
