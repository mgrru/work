package com.example.demo9;

public class Test4 {
    public static void main(String[] args) {
        MyThread4 myThread4=new MyThread4();
        Thread t1=new Thread(myThread4,"线程A");
        Thread t2=new Thread(myThread4,"线程B");
        t1.start();
        t2.start();
    }
}
