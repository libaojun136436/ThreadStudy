package com.example.thread.chapter08;

/**
 * runableDenyException是RuntimeException的子类
 * 主要用于通知任务提交者，任务队列无法再接受新的任务
 */
public class RunnableDenyException extends  RuntimeException {
    public RunnableDenyException(String message){
        super(message);
    }
}
