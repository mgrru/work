package com.example.demo9;

public class MyThread implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("线程t在运行");
            Thread.sleep(500);
            System.out.println("线程t在500毫秒休眠后重新运行");

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程中断");
        }
    }
}
