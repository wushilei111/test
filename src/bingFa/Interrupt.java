package bingFa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Interrupt {
    public static void main(String[] args) {
        Object o = new Object();
        ReentrantLock lock = new ReentrantLock();

        Thread thread = new Thread(()->{
            synchronized (o){
                System.out.println("synchronized o");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("i am interrupt and aweak");
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread12 = new Thread(()->{
            synchronized (o){
                try {
                    System.out.println(Thread.holdsLock(o));
                    System.out.println("thread2 locked o");
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread12.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("thread interrupted");
        thread12.interrupt();
        lock.lock();

    }
}
