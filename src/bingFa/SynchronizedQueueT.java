package bingFa;

import java.util.concurrent.SynchronousQueue;

public class SynchronizedQueueT {
    static SynchronousQueue synchronousQueue = new SynchronousQueue();//继承自阻塞队列，是一个容量为零的阻塞队列，
    // 内部的put方法调用其内部transfer类来将任务直接交给消费者，普通的阻塞队列将容量设为零不同于synchronousQueue
    public static void main(String[] args) {
        /*new Thread(()->{
            try {
                System.out.println(transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
        try {
            //synchronousQueue.add("aaa");因为队列为空，调用add方法将直接俄抛出Queuefull异常
            synchronousQueue.put("aaa");//  将对象直接交给消费者线程，如果没有请求对象的消费者线程者阻塞等待
            //内部由其类的内部类Transfer中的transfer实现
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
