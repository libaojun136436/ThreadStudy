package com.example.thread.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程的优先级
 * setPriority
 * 优先级不能小于1也不能大于10
 * 如果指定的线程优先级大于线程所在group的优先级，那么指定的优先级将失效，取而代之的是group的最大优先级
 */
public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });
        Thread t2 =new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        t1.setPriority(3);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }




}
