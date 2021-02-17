package com.example.thread.ExecutorService;

import java.util.concurrent.*;

/**
 * java 线程池的4中创建方法
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 *
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 *
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 *
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class makeexecutorService {
    public static void main(String[] args) {

        //newCachedThreadPool();
        //newFixedThreadPool();
        //newScheduledThreadPool();
        //newSingleThreadExecutor();
        fix();
    }

    /**
     * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     */
    public static void newCachedThreadPool(){
      ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
      for(int i=0;i<10;i++){
          final int index=i;
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          cachedThreadPool.execute(new Runnable() {
              @Override
              public void run() {
                  System.out.println(index);
              }
          });

      }

    }

    //建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    public  static  void newFixedThreadPool(){
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            final int index=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void newScheduledThreadPool(){
        ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5);
        for(int i=0;i<10;i++){
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("delay 3 seconds");
                }
            },3, TimeUnit.SECONDS);
        }

    }

    public  static void newSingleThreadExecutor(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            final  int index=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static  void fix(){
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        for(int i=0;i<10;i++){
           poolExecutor.execute(new Runnable() {
               @Override
               public void run() {
                   System.out.println("测试");
               }
           });
        }

    }

}
