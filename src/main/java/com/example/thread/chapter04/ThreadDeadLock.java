package com.example.thread.chapter04;

/**
 * 死锁的应用
 * 交叉锁引起的死锁
 */
public class ThreadDeadLock {

    private  final Object MUTEX_READ=new Object();

    private final Object MUTEX_WRITE=new Object();

    public void read(){
        synchronized (MUTEX_READ){
            System.out.println(Thread.currentThread().getName()+"拿到读的锁");
            synchronized (MUTEX_WRITE){
                System.out.println(Thread.currentThread().getName()+"拿到写的锁");
            }
            System.out.println(Thread.currentThread().getName()+"丢掉写的锁");
        }
        System.out.println(Thread.currentThread().getName()+"丢掉读的锁");
    }
    public void write(){
        synchronized (MUTEX_WRITE){
            System.out.println(Thread.currentThread().getName()+"拿到写的锁");
            synchronized (MUTEX_READ){
                System.out.println(Thread.currentThread().getName()+"拿到读的锁");
            }
            System.out.println(Thread.currentThread().getName()+"丢掉读的锁");
        }
        System.out.println(Thread.currentThread().getName()+"丢掉写的锁");
    }

    public static void main(String[] args) {
        final  ThreadDeadLock threadDeadLock=new ThreadDeadLock();
        new Thread(()->{
            while (true){
                threadDeadLock.read();
            }
        },"READ-THREAD").start();
        new Thread(()->{
            while (true){
                threadDeadLock.write();
            }
        },"WRITE-THREAD").start();
    }

}
