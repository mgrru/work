package com.ru.entity;

import java.sql.Timestamp;

public class Pet {
  private int pet_id; // 宠物编号
  private int master_id; // 宠物主人编号
  private int shop_id; // 所属商店编号
  private String pet_name; // 宠物名称
  private String type_name; // 宠物类型
  private int health; // 健康值
  private int intimacy; // 好感值
  private Timestamp birthday; // 出生日期

  public Pet() {
  }

  public Pet(int pet_id, int master_id, int shop_id, String pet_name, String type_name, int health, int intimacy,
      Timestamp birthday) {
    this.pet_id = pet_id;
    this.master_id = master_id;
    this.shop_id = shop_id;
    this.pet_name = pet_name;
    this.type_name = type_name;
    this.health = health;
    this.intimacy = intimacy;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Pet [pet_id=" + pet_id + ", master_id=" + master_id + ", shop_id=" + shop_id + ", pet_name=" + pet_name
        + ", type_name=" + type_name + ", health=" + health + ", intimacy=" + intimacy + ", birthday=" + birthday + "]";
  }

  public int get_pet_id() {
    return pet_id;
  }

  public void set_pet_id(int pet_id) {
    this.pet_id = pet_id;
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

  public String get_pet_name() {
    return pet_name;
  }

  public void set_pet_name(String pet_name) {
    this.pet_name = pet_name;
  }

  public String get_type_name() {
    return type_name;
  }

  public void set_type_name(String type_name) {
    this.type_name = type_name;
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
