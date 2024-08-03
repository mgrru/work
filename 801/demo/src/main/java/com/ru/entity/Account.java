package com.ru.entity;

public abstract class Account {
  protected int id; // 账号编号
  protected String login_name; // 登录名
  protected String login_pass; // 登录密码
  protected int balance; // 余额

  public Account() {
  }

  public Account(int id, String login_name, String login_pass, int balance) {
    this.id = id;
    this.login_name = login_name;
    this.login_pass = login_pass;
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account [id=" + id + ", login_name=" + login_name + ", login_pass=" + login_pass + ", balance=" + balance
        + "]";
  }

  public int get_id() {
    return id;
  }

  public void set_id(int id) {
    this.id = id;
  }

  public String get_login_name() {
    return login_name;
  }

  public void set_login_name(String login_name) {
    this.login_name = login_name;
  }

  public String get_login_pass() {
    return login_pass;
  }

  public void set_login_pass(String login_pass) {
    this.login_pass = login_pass;
  }

  public int get_balance() {
    return balance;
  }

  public void set_balance(int balance) {
    this.balance = balance;
  }



}
