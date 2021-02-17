package com.example.thread.chapter08;

/**
 * 用于当队列的rUnable达到了limit的上限，决定用何种策略通知提交者
 * 该接口定义了三种默认的实现
 */
@FunctionalInterface
public interface DenyPolicy {
    //拒绝方法
    void reject(Runnable runable,ThreadPool threadPool);
    //该拒绝策略会直接将任务丢弃
    class DiscardDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runable, ThreadPool threadPool) {
            System.out.println("我被丢弃了");
            //do something
        }
    }
    //该拒绝策略会向任务提交者抛出异常
    class  AbortDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runable, ThreadPool threadPool) {
            throw  new RunnableDenyException("The runable"+runable+"will be abort");
        }
    }
    //该拒绝策略会让任务在提交者所在的线程中执行任务
    class  RunnerDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runable, ThreadPool threadPool) {
            if(!threadPool.isShutdown()){
                runable.run();
            }
        }
    }


}
