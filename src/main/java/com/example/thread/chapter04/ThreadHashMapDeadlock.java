package com.example.thread.chapter04;

import java.util.HashMap;

/**
 * 死循环引起的死锁
 */
public class ThreadHashMapDeadlock {
    private final HashMap<String,String> map=new HashMap<>();
    public void add(String key,String value){
        this.map.put(key,value);
    }

    public static void main(String[] args) {
        final ThreadHashMapDeadlock hmdl=new ThreadHashMapDeadlock();
        for(int x=0;x<2;x++){
            new Thread(()->{
                for(int i=1;i<Integer.MAX_VALUE;i++){
                    hmdl.add(String.valueOf(i),String.valueOf(i));
                }
            }).start();
        }
    }
}
