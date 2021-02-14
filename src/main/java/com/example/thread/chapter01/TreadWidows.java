package com.example.thread.chapter01;

/**
 * 窗口叫号机继承Thread类
 */
public class TreadWidows extends Thread {

    private  final  String name;
    private static final  int max=1000;
    private static int index=1;

    public TreadWidows(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        while (index<=max){
            System.out.println("柜台："+name+"当前号码为："+(index++));
        }
    }

    public static void main(String[] args) {
        new TreadWidows("一号柜台机").start();
        new TreadWidows("二号柜台机").start();
        new TreadWidows("三号柜台机").start();
        new TreadWidows("四号柜台机").start();

    }


}
