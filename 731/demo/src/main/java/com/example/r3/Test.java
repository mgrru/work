package com.example.r3;

public class Test {
    public static void main(String[] args) {
        Thread temp=new Thread(new MyThread());

        temp.start();

        for (int i = 0; i <= 50; i++) {

            if(i == 10){
                try {
                    temp.join();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(600);
            }catch (InterruptedException e) {

            }
            System.out.println( "普通号病人: " + i + "号病人正在看病！");
        }
    }
}
