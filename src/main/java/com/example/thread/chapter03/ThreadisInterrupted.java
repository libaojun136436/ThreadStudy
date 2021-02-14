package com.example.thread.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 调用线程的interrupt可以打断阻塞，但要记住必须是别的线程调用它的interrupt()方法
 * isIntrrupte方法和interrupted方法都调用了同一个本地方法isInterrupted(boolean ClearIntettupted)
 *
 */
public class ThreadisInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
              System.out.println("我被interrupted方法调用了");
            }
        });
        thread.start();
        System.out.printf("isterrupted ? %s\n",thread.isInterrupted());
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
        System.out.printf("isterrupted ? %s\n",thread.isInterrupted());

    }


}
