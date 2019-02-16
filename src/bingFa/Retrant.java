package bingFa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Retrant {
    static class Retrant1{

        public static void main(String[] args) {
            Lock lock = new ReentrantLock();
            Retrant1 retrant1 = new Retrant1();

            new Thread(()->{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+Thread.holdsLock(lock));
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();
            Thread t2 = new Thread(()->{
                try{
                    System.out.println("t2 start");
                    lock.tryLock(10,TimeUnit.SECONDS);
                    lock.lockInterruptibly();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("m1 end");
                }catch (Exception e){
                    System.out.println(e);
                }finally {
                    try {
                        lock.unlock();
                    } catch (IllegalMonitorStateException e) {
                    }
                }
            });
            t2.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("will interrupt");
            t2.interrupt();
            System.out.println(" interrupted");
        }
    }
}
