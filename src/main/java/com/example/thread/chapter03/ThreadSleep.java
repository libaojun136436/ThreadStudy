package com.example.thread.chapter03;

/**
 * 线程休眠
 * 可以看出来main线程和thread线程休眠的时间互不相同，互不影响
 *  但是发现一个特殊的现象sleep不准时 原因： windows不是实时操作系统。
 */
public class ThreadSleep {

    public static void main(String[] args) {
        new Thread(()->{
            long startTime=System.currentTimeMillis();
            sleep(50_000L);
            long endTime=System.currentTimeMillis();
            System.out.println(String.format("Total spend%d ms",(endTime-startTime)));
            while (true){

            }
        }).start();
        long startTime=System.currentTimeMillis();
        sleep(1_000L);
        long endTime=System.currentTimeMillis();
        System.out.println(String.format("main thread total spend%d ms:",(endTime-startTime)));
    }

    private static  void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
