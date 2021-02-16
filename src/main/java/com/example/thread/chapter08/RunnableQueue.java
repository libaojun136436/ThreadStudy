package com.example.thread.chapter08;

/**
 * 任务队列用于缓存提交到线程池中的任务
 * 用于存放提交的Runable,该runable是一个BlockedQueue,并且有limit的限制
 */
public interface RunnableQueue {
    //当有新任务进来首先会offer到队列中
    void offer(Runnable runnable);
    //工作线程通过take方法获取Runable
    Runnable take() throws InterruptedException;
    //获取任务队列中任务的数量
    int size();


}
