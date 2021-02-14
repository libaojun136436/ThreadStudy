package com.example.thread.chapter01;

import java.util.stream.IntStream;

public class ThreadNameTest {

    /**
     * 多线程命名
     */
    private final  static String THREAD_NAME_PREFIX="JHP-";


    public static void main(String[] args) {
        IntStream.range(0,5).mapToObj(index->{
            return new Thread( () -> System.out.println(Thread.currentThread().getName()),
                    THREAD_NAME_PREFIX + index);
        }).forEach(Thread::start);


    }




}
