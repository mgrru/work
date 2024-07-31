package com.example.demo4;

public class TDoor extends Door implements Lock{

  @Override
  public void lock_up() {
    System.out.println("上锁");
  }

  @Override
  public void open_lock() {
    System.out.println("开锁");
  }

}
