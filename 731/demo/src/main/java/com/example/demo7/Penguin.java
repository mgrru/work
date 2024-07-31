package com.example.demo7;

public class Penguin extends Pet {
  String sex;

  Penguin(String name, String sex) {
    super(name);
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "Penguin [name=" + name + ", sex=" + sex + "]";
  }

}
