package com.example.thread.chapter02;

/**
 * 获取线程的id 或者name等信息
 */
public class CurrentThread {

    public static void main(String[] args) {

        Thread thread=new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getId());
                System.out.println(Thread.currentThread()==this);
            }
        };
        thread.start();
        System.out.println("main".equals(Thread.currentThread().getName()));


    }

}
