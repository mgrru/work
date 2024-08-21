package com.example.pojo;

import java.util.List;

public class Product {
  private Integer id;
  private String name;
  private Double price;
  private List<Order> orders;

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder
        .append("Product {id=")
        .append(id)
        .append(", name=")
        .append(name)
        .append(", price=")
        .append(price)
        .append(", orders=")
        .append(orders)
        .append("}");
    return builder.toString();
  }

  public Product() {
  }

  public Product(Integer id, String name, Double price, List<Order> orders) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.orders = orders;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

}
