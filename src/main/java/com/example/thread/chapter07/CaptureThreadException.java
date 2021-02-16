package com.example.thread.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * 使用UncaughtExceptionHandler捕获异常
 * EventBus借助一个ExceptionHandler进行回调处理的6
 */
public class CaptureThreadException {

    public static void main(String[] args) {
        //1.设置回调接口、
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName()+"occur exception");
            e.printStackTrace();
        });
        final  Thread thread=new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //2 这里出现unchecked异常
            System.out.println(1/0);

        },"TEST-THREAD");
        thread.start();
    }
}
