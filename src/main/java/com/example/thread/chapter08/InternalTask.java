package com.example.thread.chapter08;

/**
 * 是runnable 的一个实现,主要是用于线程池内部，该类会使用到RunnableQueue,然后不断地从
 * queue中取出某个runnable，并运行runnable 的run方法
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;
    private volatile boolean running=true;

    public InternalTask(RunnableQueue runnableQueue){
        this.runnableQueue=runnableQueue;
    }


    @Override
    public void run() {
      //如果当前任务为running并且没有被中断，则将不断地从queue中获取runable，然后执行run方法
        while (running&&!Thread.currentThread().isInterrupted()){
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running=false;
                break;
            }

        }

    }
    //停止当前任务，主要会在线程池的shutdown方法中使用
    public void stop(){
        this.running=false;
    }
}
