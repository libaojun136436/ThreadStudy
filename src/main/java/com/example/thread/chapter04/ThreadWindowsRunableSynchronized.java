package com.example.thread.chapter04;

/**
 * 通过家synchronized 锁来避免叫号重复、不一致等问题
 */
public class ThreadWindowsRunableSynchronized implements  Runnable{

    private static final  int max=500;
    private  int index=1;
    private final static Object MUTEX=new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            while (index<=max){
                System.out.println("柜台："+Thread.currentThread()+"当前号码为："+(index++));
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            }
        }
    }

    public static void main(String[] args) {

        final ThreadWindowsRunable task=new ThreadWindowsRunable();
        new Thread(task,"一号窗口").start();
        new Thread(task,"二号窗口").start();
        new Thread(task,"三号窗口").start();
        new Thread(task,"四号窗口").start();

    }
}
