package com.example.r2;

public class CommonHanset extends Handset implements PlayWiring {

  public CommonHanset(String brand, String type) {
    super(brand, type);
  }

  @Override
  public void play(String content) {
    System.out.println("播放音乐《" + content + "》...");
  }

}
