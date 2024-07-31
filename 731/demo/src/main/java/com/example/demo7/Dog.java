package com.example.demo7;

public class Dog extends Pet{
  String strain;

  Dog(String name,String strain) {
    super(name);
    this.strain=strain;
  }

  @Override
  public String toString() {
    return "Dog [name=" + name + ", strain=" + strain + "]";
  }


  
}
