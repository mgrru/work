package com.example.r3;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("特需号:"+i+"病人正在看病！");
        }
    }

}
