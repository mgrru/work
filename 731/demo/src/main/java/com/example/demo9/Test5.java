package com.example.demo9;

public class Test5 {
    public static void main(String[] args) {
        ClimbThread young=new ClimbThread("年轻人",500,1);
        ClimbThread old=new ClimbThread("老轻人",1500,1);
        System.out.println("***爬山开始***");
        young.start();
        old.start();

    }
}
