package com.ru.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ru.dao.BaseDao;
import com.ru.dao.BillDao;
import com.ru.entity.Bill;
import com.ru.entity.Shop;

public class BillDaoImpl extends BaseDao implements BillDao {
  private static final Logger logger = LogManager.getLogger(BillDaoImpl.class);

  @Override
  public void add(Bill bill) {
    String sql = "insert into bill values(?,?,?,?,?,?,?,?)";
    Object[] params = {
        bill.get_id(),
        bill.get_shop_id(),
        bill.get_pet_id(),
        bill.get_seller_id(),
        bill.get_buyer_id(),
        bill.get_transaction_type(),
        bill.get_transaction_price(),
        bill.get_transaction_time()
    };

    try {
      executeUpdate(sql, params);
      logger.info("添加账单");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public List<Bill> get_all_by_shop(Shop shop) {
    String sql = "select * from bill where shop_id=?";
    List<Bill> result = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, shop.get_id());
      rs = stmt.executeQuery();
      while (rs.next()) {
        Bill bill = new Bill();
        bill.set_id(rs.getInt(0));
        bill.set_shop_id(rs.getInt(1));
        bill.set_pet_id(rs.getInt(2));
        bill.set_seller_id(rs.getInt(3));
        bill.set_buyer_id(rs.getInt(4));
        bill.set_transaction_type(rs.getString(5));
        bill.set_transaction_price(rs.getInt(6));
        bill.set_transaction_time(rs.getTimestamp(7));
        result.add(bill);
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return result;
  }

}
