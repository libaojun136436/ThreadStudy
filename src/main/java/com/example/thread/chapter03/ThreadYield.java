package com.example.thread.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 线程礼让
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 3).mapToObj(index->{
            return new Thread(() -> {
                if (index == 1) {
                    Thread.yield();
                    System.out.println("我只是进入了runable状态，我并不是被杀掉");
                }
                if (index==2){
                    System.out.println("我会不会先被执行");
                }
                System.out.println(index);
            });
        }).forEach(Thread::start);
    }
}
