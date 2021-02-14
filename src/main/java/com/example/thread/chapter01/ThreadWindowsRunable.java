package com.example.thread.chapter01;

import java.util.concurrent.TimeUnit;

public class ThreadWindowsRunable implements Runnable {

    private static final  int max=50;
    private  int index=1;

    @Override
    public void run() {
        while (index<=max){
            System.out.println("柜台："+Thread.currentThread()+"当前号码为："+(index++));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final  ThreadWindowsRunable task=new ThreadWindowsRunable();
        new Thread(task,"一号窗口").start();
        new Thread(task,"二号窗口").start();
        new Thread(task,"三号窗口").start();
        new Thread(task,"四号窗口").start();

    }
}
