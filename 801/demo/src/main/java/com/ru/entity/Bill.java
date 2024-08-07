package com.ru.entity;

import java.sql.Timestamp;

public class Bill {
  private int id; // 账单编号
  private int shop_id; // 商店编号
  private int pet_id; // 宠物编号
  private int seller_id; // 宠物主人编号
  private int buyer_id; // 买家编号
  private String transaction_type; // 交易类型(购买/出售)
  private int transaction_price; // 交易金额
  private Timestamp transaction_time; // 交易时间

  public Bill() {
  }

  public Bill(int id, int shop_id, int pet_id, int seller_id, int buyer_id, String transaction_type, int transaction_price,
      Timestamp transaction_time) {
    this.id = id;
    this.shop_id = shop_id;
    this.pet_id = pet_id;
    this.seller_id = seller_id;
    this.buyer_id = buyer_id;
    this.transaction_type = transaction_type;
    this.transaction_price = transaction_price;
    this.transaction_time = transaction_time;
  }

  @Override
  public String toString() {
    return "Bill [id=" + id + ", shop_id=" + shop_id + ", pet_id=" + pet_id + ", seller_id=" + seller_id + ", buyer_id="
        + buyer_id + ", transaction_type=" + transaction_type + ", transaction_price=" + transaction_price
        + ", transaction_time=" + transaction_time + "]";
  }

  public int get_id() {
    return id;
  }

  public void set_id(int id) {
    this.id = id;
  }

  public int get_seller_id() {
    return seller_id;
  }

  public void set_seller_id(int seller_id) {
    this.seller_id = seller_id;
  }

  public int get_pet_id() {
    return pet_id;
  }

  public void set_pet_id(int pet_id) {
    this.pet_id = pet_id;
  }

  public int get_buyer_id() {
    return buyer_id;
  }

  public void set_buyer_id(int buyer_id) {
    this.buyer_id = buyer_id;
  }

  public String get_transaction_type() {
    return transaction_type;
  }

  public void set_transaction_type(String transaction_type) {
    this.transaction_type = transaction_type;
  }

  public int get_transaction_price() {
    return transaction_price;
  }

  public void set_transaction_price(int transaction_price) {
    this.transaction_price = transaction_price;
  }

  public Timestamp get_transaction_time() {
    return transaction_time;
  }

  public void set_transaction_time(Timestamp transaction_time) {
    this.transaction_time = transaction_time;
  }

  public int get_shop_id() {
    return shop_id;
  }

  public void set_shop_id(int shop_id) {
    this.shop_id = shop_id;
  }
}
