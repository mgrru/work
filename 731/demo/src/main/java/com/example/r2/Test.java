package com.example.r2;

public class Test {
  public static void main(String[] args) {
    CommonHanset hanset1 = new CommonHanset("索尼艾莉", "G502d");
    hanset1.info();
    hanset1.play("music");
    hanset1.send_msg();
    hanset1.call();

    System.out.println();
    AptitudeHandset handset2 = new AptitudeHandset("I900", "htc");
    handset2.info();
    handset2.conn_network();
    handset2.play("小时代");
    handset2.take_pictures();
    handset2.send_msg();
    handset2.call();
  }
}
