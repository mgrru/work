package com.example.demo9;

public class Test2 {
    public static void main(String[] args) {
        Thread t1=new Thread(new MyThread2(),"线程A");
        Thread t2=new Thread(new MyThread2(),"线程B");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("线程A的优先级:"+t1.getPriority());
        System.out.println("线程B的优先级:"+t2.getPriority());
        System.out.println("*************");
        t1.start();
        t2.start();

    }
}
