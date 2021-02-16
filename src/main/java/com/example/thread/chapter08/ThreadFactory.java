package com.example.thread.chapter08;

/**
 * 提供创建线程的接口，已便于个性化制定Thread,比如Thread应该被放到那个组，优先级、线程名称等。
 */
@FunctionalInterface
public interface ThreadFactory {
    //用于创建线程
    Thread createThread(Runnable runnable);
}
