package com.example.pojo;

public class Worker {
  private Integer id;
  private String name;
  private Integer age;
  private String sex;
  private Integer worker_id;

  @Override
  public String toString() {
    return "Worker{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", sex='" + sex + '\'' +
        ", worker_id=" + worker_id +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getWorkerId() {
    return worker_id;
  }

  public void setWorkerId(Integer worker_id) {
    this.worker_id = worker_id;
  }
}
