package com.example.thread.chapter01;

/**
 * 父级线程 ThreadGrop
 *   main线程所在的线程组是main
 *  构建ige线程的时候如果没有显式地指定ThreadGroup，那么它将会和父线程同属同一个线程组
 */
public class ThreadGropTest {

    public static void main(String[] args) {

        ThreadGroup group=new ThreadGroup("测试线程组");
        Thread t1=new Thread("线程1");
        Thread t2=new Thread(group,"线程2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("mainThreadGroup.getName: " + mainThreadGroup.getName());
        System.out.println("t1.getName: " + t1.getThreadGroup().getName());
        System.out.println("t2.getName: " + t2.getThreadGroup().getName());
        System.out.println("t2 and group : " + (t2.getThreadGroup().getName() == group.getName()));



    }

}
