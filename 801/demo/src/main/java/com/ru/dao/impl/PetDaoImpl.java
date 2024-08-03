package com.ru.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.ru.dao.MysqlDao;
import com.ru.dao.PetDao;
import com.ru.entity.Pet;

public class PetDaoImpl extends MysqlDao implements PetDao {
  private static final Logger logger = LogManager.getLogger(PetDaoImpl.class);

  @Override
  public void save(Pet pet) {
    String sql = "insert into pet values(?,?,?,?,?,?,?,?)";
    Object[] params = {
        pet.get_pet_id(),
        pet.get_master_id(),
        pet.get_shop_id(),
        pet.get_pet_name(),
        pet.get_type_name(),
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
    String sql = "delete from pet where pet_id=?";
    Object[] params = { pet.get_pet_id() };
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
        + "pet_name=?"
        + "type_name=?"
        + "health=?"
        + "intimacy=?"
        + "birthday=?"
        + " where pet_id=?";
    Object[] params = {
        pet.get_master_id(),
        pet.get_shop_id(),
        pet.get_pet_name(),
        pet.get_type_name(),
        pet.get_health(),
        pet.get_intimacy(),
        pet.get_birthday(),
        pet.get_pet_id()
    };

    try {
      executeUpdate(sql, params);
      logger.info("删除宠物");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  public List<Pet> get_all() {
    String sql = "select * from pet";
    List<Pet> result = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      while (rs.next()) {
        Pet pet = new Pet();
        pet.set_pet_id(rs.getInt(0));
        pet.set_master_id(rs.getInt(1));
        pet.set_shop_id(rs.getInt(2));
        pet.set_pet_name(rs.getString(3));
        pet.set_type_name(rs.getString(4));
        pet.set_health(rs.getInt(5));
        pet.set_intimacy(rs.getInt(6));
        pet.set_birthday(rs.getTimestamp(7));
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
