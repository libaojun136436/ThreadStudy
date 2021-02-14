package com.example.thread.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * 如果把最大值调整为500 会出现一些问题
 * 某个号码被掠过没有出现
 * 某个号码被多次显示
 * 号码超过了额最大值
 */
public class ThreadWindowsRunable implements Runnable {

    private static final  int max=500;
    private  int index=1;

    @Override
    public void run() {
        while (index<=max){
            System.out.println("柜台："+Thread.currentThread()+"当前号码为："+(index++));
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) {

        final ThreadWindowsRunable task=new ThreadWindowsRunable();
        new Thread(task,"一号窗口").start();
        new Thread(task,"二号窗口").start();
        new Thread(task,"三号窗口").start();
        new Thread(task,"四号窗口").start();

    }
}
