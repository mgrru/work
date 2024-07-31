package com.example.r2;

public class AptitudeHandset extends Handset implements PlayWiring, Network, TheakePictures {
  AptitudeHandset(String brand, String type) {
    super(brand, type);
  }

  @Override
  public void take_pictures() {
    System.out.println("拍照...");
  }

  @Override
  public void conn_network() {
    System.out.println("连接网络...");
  }

  @Override
  public void play(String content) {
    System.out.println("播放视频《" + content + "》...");
  }

  @Override
  void call() {
    System.out.println("视频通话...");
  }

  @Override
  void send_msg() {
    System.out.println("发送图片和文字信息...");
  }

}
