package com.ru.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.ru.dao.BaseDao;
import com.ru.dao.PetDao;
import com.ru.entity.Master;
import com.ru.entity.Pet;
import com.ru.entity.Shop;

public class PetDaoImpl extends BaseDao implements PetDao {
  private static final Logger logger = LogManager.getLogger(PetDaoImpl.class);

  @Override
  public void add(Pet pet) {
    String sql = "insert into pet values(?,?,?,?,?,?,?,?)";
    Object[] params = {
        pet.get_id(),
        pet.get_master_id(),
        pet.get_shop_id(),
        pet.get_name(),
        pet.get_type(),
        pet.get_health(),
        pet.get_intimacy(),
        pet.get_birthday()
    };

    try {
      executeUpdate(sql, params);
      logger.info("添加宠物");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void del(Pet pet) {
    String sql = "delete from pet where id=?";
    Object[] params = { pet.get_id() };
    try {
      executeUpdate(sql, params);
      logger.info("删除宠物");

    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public void update(Pet pet) {
    String sql = "update pet set "
        + "master_id=?"
        + "shop_id=?"
        + "name=?"
        + "type=?"
        + "health=?"
        + "intimacy=?"
        + "birthday=?"
        + " where id=?";
    Object[] params = {
        pet.get_master_id(),
        pet.get_shop_id(),
        pet.get_name(),
        pet.get_type(),
        pet.get_health(),
        pet.get_intimacy(),
        pet.get_birthday(),
        pet.get_id()
    };

    try {
      executeUpdate(sql, params);
      logger.info("删除宠物");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  @Override
  public List<Pet> get_all_by_master(Master master) {
    String sql = "select * from pet where master_id=?";
    List<Pet> result = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, master.get_id());
      rs = stmt.executeQuery();
      while (rs.next()) {
        Pet pet = new Pet();
        pet.set_id(rs.getInt(1));
        pet.set_master_id(rs.getInt(2));
        pet.set_shop_id(rs.getInt(3));
        pet.set_name(rs.getString(4));
        pet.set_type(rs.getString(5));
        pet.set_health(rs.getInt(6));
        pet.set_intimacy(rs.getInt(7));
        pet.set_birthday(rs.getTimestamp(8));
        result.add(pet);
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return result;
  }

  @Override
  public List<Pet> get_all_by_shop(Shop shop) {
    String sql = "select * from pet where shop_id=?";
    List<Pet> result = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, shop.get_id());
      rs = stmt.executeQuery();
      while (rs.next()) {
        Pet pet = new Pet();
        pet.set_id(rs.getInt(1));
        pet.set_master_id(rs.getInt(2));
        pet.set_shop_id(rs.getInt(3));
        pet.set_name(rs.getString(4));
        pet.set_type(rs.getString(5));
        pet.set_health(rs.getInt(6));
        pet.set_intimacy(rs.getInt(7));
        pet.set_birthday(rs.getTimestamp(8));
        result.add(pet);
      }
    } catch (Exception e) {
      logger.error(e);
    } finally {
      closeAll(conn, stmt, rs);
    }

    return result;
  }

}
