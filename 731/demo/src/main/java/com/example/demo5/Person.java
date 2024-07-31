package com.example.demo5;

public class Person {
  private String sex;

  public Person() {
  }

  public Person(String sex) {
    this.sex = sex;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) throws Exception {
    if ("男".equals(sex) || "女".equals(sex)) {
      this.sex = sex;
    } else {
      throw new Exception("性别只能是男/女");
    }

  }

}
