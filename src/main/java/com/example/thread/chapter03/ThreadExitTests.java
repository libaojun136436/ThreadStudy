package com.example.thread.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程关闭的方法
 */
public class ThreadExitTests {

    private static volatile boolean closed=false;

    public static void main(String[] args) throws InterruptedException {
        //InterruptThreadExit();
        flagThreadExit();
    }

    /**
     * 捕获中断信号关闭线程
     * 使用线程的interrupt的标识来决定是否退出，如果在线程中又可中断的方法，则可以捕获中断信号来决定是否退出
     */
    public static void InterruptThreadExit() throws InterruptedException {
        Thread t=new Thread(){
          @Override
          public void run(){
              System.out.println("我还活着");
              while(!isInterrupted()){
                  //working
              }
              System.out.println("我要离开了");
          }
        };

        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("系统要关闭了");
        t.interrupt();
    }

    /**
     * 使用volatile修饰词来关闭 因为volatile修饰的变量具有可见性 所以用它来设置关闭开关
     * @throws InterruptedException
     */
    public static void   flagThreadExit() throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run(){
             System.out.println("我在工作中");
             while (!closed&&!isInterrupted()){
                 //正在运行
                 System.out.println("我还下不了班");
             }
             System.out.println("我要下班了");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(6);
        System.out.println("系统要退出了");
        closed(t);
    }

    private static void closed(Thread t) {
        closed=true;
        t.interrupt();
    }







}
