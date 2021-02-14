package com.example.thread.chapter01;

import java.util.concurrent.TimeUnit;

/**
 *  联系
 *
 */
public class ThreadTests {

    public static void main(String[] args)  {
        //browseNews(); //通过控制台可以看出来只有good news 在 一直运行，听歌是出不来的
       // new Thread(ThreadTests::browseNews).start();
        new Thread(ThreadTests::browseNews).start();
        //enjoyMusic();
        new Thread(ThreadTests::enjoyMusic).start();
    }

    public static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    public static void enjoyMusic() {
       /* new Thread(ThreadTests::browseNews).start();
        new Thread(ThreadTests::browseNews).start(); {
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }*/
       for(;;){
           System.out.println("Uh-huh, the nice music.");
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
