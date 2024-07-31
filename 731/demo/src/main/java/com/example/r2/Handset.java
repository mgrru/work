package com.example.r2;

public class Handset {
  String brand;
  String type;

  Handset() {
  }

  Handset(String brand, String type) {
    this.brand = brand;
    this.type = type;
  }

  void info() {
    System.out.println("这是型号为" + type + "的" + brand + "手机:");
  }

  void send_msg() {
    System.out.println("发送信息...");
  }

  void call() {
    System.out.println("语音通话...");
  }
}
