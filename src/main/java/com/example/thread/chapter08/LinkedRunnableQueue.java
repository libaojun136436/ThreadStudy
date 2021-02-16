package com.example.thread.chapter08;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {
    //任务队列的最大容量，在构造时传入
    private final int limit;
    //任务队列中的任务已经满了，则需要执行拒绝策略
    private final DenyPolicy denyPolicy;
    //存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();
    private final ThreadPool threadPool;
    //limit 也就是Runnable队列的上限；当提交的Runnable数量达到limit上限，则会调用DenyPolicy的reject方法
    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }
    //offer方法时一个同步方法，如果队列数量达到了上限，则会执行拒绝策略，否则会将runnable放到队列中，
    // 同时唤醒take任务的线程
    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            //无法容纳新的任务时执行拒绝策略
            if (runnableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                //将任务加入到队尾，并且唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }
    //take 方法也是同步方法，线程不断从队列中获取Runnable任务，当队列为空的时候工作线程会陷入阻塞
    //也可能在阻塞的工程中被中断，为了传递中断信号需要在catch语句块中将异常抛出已通知上游InternalTask
    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    //如果队列中没有可执行的任务，则当前线程将会挂起，进入runableList关联的monitor
                    // waitset中等待唤醒（新的任务加入）
                    runnableList.wait();
                } catch (InterruptedException e) {
                    //被中断时需要将异常抛出
                    throw e;
                }

            }
            //从任务队列头部移出一个任务
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList){
            //返回当前队列中的任务数
            return runnableList.size();
        }
    }
}
