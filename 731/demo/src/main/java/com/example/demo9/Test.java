package com.example.demo9;

public class Test {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread());
        System.out.println("线程t新建");
        thread.start();
        System.out.println("线程t就绪");
    }
}
