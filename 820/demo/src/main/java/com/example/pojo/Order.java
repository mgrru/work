package com.example.pojo;

public class Order {
  private Integer id;
  private String number;
  private Integer user_id;

  public Order() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Integer getUserId() {
    return user_id;
  }

  public void setUserId(Integer user_id) {
    this.user_id = user_id;
  }

  public Order(Integer id, String number, Integer user_id) {
    this.id = id;
    this.number = number;
    this.user_id = user_id;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Order {id=").append(id).append(", number=").append(number).append(", user_id=").append(user_id)
        .append("}");
    return builder.toString();
  }

}
