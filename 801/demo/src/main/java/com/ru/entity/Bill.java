package com.ru.entity;

import java.sql.Timestamp;

public class Bill {
  private int bill_id; // 账单编号
  private int pet_id; // 宠物编号
  private int master_id; // 宠物主人编号
  private int buyer_id; // 买家编号
  private int transaction_type; // 交易类型(购买/出售)
  private int transaction_price; // 交易金额
  private Timestamp transaction_time; // 交易时间

  public Bill() {
  }

  public Bill(int bill_id, int pet_id, int master_id, int buyer_id, int transaction_type,
      int transaction_price, Timestamp transaction_time) {
    this.bill_id = bill_id;
    this.master_id = master_id;
    this.pet_id = pet_id;
    this.buyer_id = buyer_id;
    this.transaction_type = transaction_type;
    this.transaction_price = transaction_price;
    this.transaction_time = transaction_time;
  }

  @Override
  public String toString() {
    return "AccountInfo [bill_id=" + bill_id + ", pet_id=" + pet_id + ", master_id=" + master_id + ", buyer_id="
        + buyer_id + ", transaction_type=" + transaction_type + ", transaction_price=" + transaction_price
        + ", transaction_time=" + transaction_time + "]";
  }

  public int get_bill_id() {
    return bill_id;
  }

  public void set_bill_id(int bill_id) {
    this.bill_id = bill_id;
  }

  public int get_master_id() {
    return master_id;
  }

  public void set_master_id(int master_id) {
    this.master_id = master_id;
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

  public int get_transaction_type() {
    return transaction_type;
  }

  public void set_transaction_type(int transaction_type) {
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
}
