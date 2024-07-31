package com.example.demo5;

public class Test2 {
  public static void main(String[] args) {
    Person person = new Person();
    try {
      person.setSex("null");
    } catch (Exception e) {
      e.printStackTrace();
      // e.getMessage();
    }
  }
}
