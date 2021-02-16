package com.example.thread.chapter05;

import java.util.LinkedList;

/**
 * 单线程通讯
 * 消息队列
 * 在eventQueue中定义了一个队列，offer方法会提交一个event到列尾，如果此时队列已经满了，那么提交的队列就会被阻塞
 * 同样take会从对头获取数据，刚队列中没有数据，那么工作线程就会被阻塞
 * 此外notify 方法作用是唤醒曾经执行wait方法而进入阻塞的线程
 */
public class EventQueue {

    private final  int max;
    private final LinkedList<Event> eventQueue=new LinkedList<>();
    private final  static  int DEFAULT_MAX_EVENT=10;
    public EventQueue(int max) {
        this.max = max;
    }
    static class Event{}
    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }
    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size()>=max){
                try {
                    console("the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the event us submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }

    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try {
                    console("the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event=eventQueue.removeFirst();
            this.eventQueue.notify();
            console("the event" +event +"is handled");
            return  event;
        }
    }

    private void console(String message){
        System.out.printf("%s:%s\n",Thread.currentThread().getName(),message);
    }

}
