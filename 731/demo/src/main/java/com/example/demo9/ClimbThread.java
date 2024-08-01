package com.example.demo9;

public class ClimbThread extends Thread {
    private int time;//爬100米的时间
    public int num=0;//需要爬多少个100米

    /**
     *
     * @param name 人名
     * @param time 爬100米的时间
     * @param kilometer 山的高度千米
     */
    public ClimbThread(String name, int time, int kilometer) {
        super(name);
        this.time = time;
        this.num = kilometer*1000/100;
    }

    public void run(){
        while (num>0){
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"爬完100米");
            num--;
        }
        System.out.println(Thread.currentThread().getName()+"到达终点");
    }
}
