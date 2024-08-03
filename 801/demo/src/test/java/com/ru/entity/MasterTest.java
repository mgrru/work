package com.ru.entity;

import org.junit.Test;

public class MasterTest {
  @Test
  public void testGet_balance() {
    Account master = new Master(1, "fufu", "123", 100);
    int balance = master.get_balance();
    System.out.println("余额：" + balance);
  }

  @Test
  public void testGet_id() {

  }

  @Test
  public void testGet_login_name() {

  }

  @Test
  public void testGet_login_pass() {

  }

  @Test
  public void testSet_balance() {

  }

  @Test
  public void testSet_id() {

  }

  @Test
  public void testSet_login_name() {

  }

  @Test
  public void testSet_login_pass() {

  }

  @Test
  public void testToString() {

  }
}
