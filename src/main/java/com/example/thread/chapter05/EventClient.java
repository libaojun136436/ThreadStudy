package com.example.thread.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程通信客户端
 * 生产者很快就提交了10个event数据，此时队列已经满了，那么它将执行eventQueue的wait方法进而进入阻塞状态
 * 消费者线程由于要处理数据，所以会花费大概1毫秒的时间来处理其中的一条数据，进而通知生产者可以继续提交数据了，如此循环往复
 */
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue=new EventQueue();
        new Thread(()->{
           for(;;){
               eventQueue.offer(new EventQueue.Event());
           }
        },"生产者").start();
        new Thread(()->{
            for(;;){
                try {
                    eventQueue.take();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }
}
