package com.ru.entity;

import java.sql.Timestamp;

public class Pet {
  private int id; // 宠物编号
  private int master_id; // 宠物主人编号
  private int shop_id; // 所属商店编号
  private String name; // 宠物名称
  private String type; // 宠物类型
  private int health; // 健康值
  private int intimacy; // 好感值
  private Timestamp birthday; // 出生日期

  public Pet() {
  }

  public Pet(int id, int master_id, int shop_id, String name, String type, int health, int intimacy,
      Timestamp birthday) {
    this.id = id;
    this.master_id = master_id;
    this.shop_id = shop_id;
    this.name = name;
    this.type = type;
    this.health = health;
    this.intimacy = intimacy;
    this.birthday = birthday;
  }

  public int get_id() {
    return id;
  }

  public void set_id(int id) {
    this.id = id;
  }

  public int get_master_id() {
    return master_id;
  }

  public void set_master_id(int master_id) {
    this.master_id = master_id;
  }

  public int get_shop_id() {
    return shop_id;
  }

  public void set_shop_id(int shop_id) {
    this.shop_id = shop_id;
  }

  public String get_name() {
    return name;
  }

  public void set_name(String name) {
    this.name = name;
  }

  public String get_type() {
    return type;
  }

  public void set_type(String type) {
    this.type = type;
  }

  public int get_health() {
    return health;
  }

  public void set_health(int health) {
    this.health = health;
  }

  public int get_intimacy() {
    return intimacy;
  }

  public void set_intimacy(int intimacy) {
    this.intimacy = intimacy;
  }

  public Timestamp get_birthday() {
    return birthday;
  }

  public void set_birthday(Timestamp birthday) {
    this.birthday = birthday;
  }

}
