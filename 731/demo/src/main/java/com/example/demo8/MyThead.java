package com.example.demo8;

public class MyThead extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " - " + i);
    }
  }
}
