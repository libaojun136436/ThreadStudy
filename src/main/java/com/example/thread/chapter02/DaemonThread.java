package com.example.thread.chapter02;

/**
 * 非守护线程：我们平时写的线程都为非守护线程
 * 守护线程
 * 任何一个守护线程都会守护整个JVM中所有的非守护线程，只要当前JVM中还有任何一个非守护线程没有结束，
 * 守护线程就全部工作，当所有的非守护线程全部结束后，守护线程也会随着JVM一同结束。
 * 守护线程最典型的应用就是GC（垃圾回收器）。
 * 当你希望关闭某些线程的时候，或者推出JVM进程的时候，一些线程能自动关闭，此时就需要用守护线程完成你的需求。
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while (true){
                try {
                    System.out.println("我是thread1");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2_00l);
        System.out.println("Main thread finished lifecycle");
    }


}
