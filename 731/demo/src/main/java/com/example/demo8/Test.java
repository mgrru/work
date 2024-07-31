package com.example.demo8;

public class Test {
  public static void main(String[] args) {
    MyThead myThead = new MyThead();
    MyThead myThead2 = new MyThead();
    MyRunnable myRunnable = new MyRunnable();
    Thread thread = new Thread(myRunnable);

    myThead2.start();
    myThead.start();

    thread.start();
  }
}
