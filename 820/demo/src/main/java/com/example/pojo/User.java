package com.example.pojo;

import java.util.List;

public class User {
  private Integer id;
  private String username;
  private String address;
  private List<Order> orders;

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User(Integer id, String username, String address, List<Order> orders) {
    this.id = id;
    this.username = username;
    this.address = address;
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "User {id=" + id + ", username=" + username + ", address=" + address + ", orders=" + orders + "}";
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
