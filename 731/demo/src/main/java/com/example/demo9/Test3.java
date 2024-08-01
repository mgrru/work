package com.example.demo9;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("*****线程强制启动*****");
        Thread temp=new Thread(new MyThread3());
        temp.start();
        for (int i = 0; i <20 ; i++) {
            if(i==5){
                try {
                    temp.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行:"+i);
        }
    }
}
