package com.example.thread.chapter03;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * join 某个线程A，会使当前线程B进入等待，直到A结束生命周期，或者达到指定的时间，
 * 那么此期间B线程是出于BLOCKED的，而不是A
 *
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Thread  t1=new Thread(()->{
            for(int i=1;i<8;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程A"+i);
            }

        });
        Thread  t3=new Thread(()->{
            for(int i=1;i<8;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程C"+i);
            }

        });

        t1.start();
        t3.start();
        new Thread(()->{
            try {
                t1.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=1;i<8;i++){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程B"+i);
            }

        }).start();
    }



}
