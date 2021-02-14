package com.example.thread.chapter04;

import sun.awt.Mutex;

import java.util.concurrent.TimeUnit;

/**
 * 锁的简单应用
 */
public class ThreadMute {
    private final static  Object MUTEX=new Object();
    public void accessResource(){
        synchronized (MUTEX){
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final  ThreadMute mutex=new ThreadMute();
        for(int i=0;i<5;i++){
            new Thread(mutex::accessResource).start();
        }

    }
}
