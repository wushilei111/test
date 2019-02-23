package bingFa;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierT {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(3,()->{
            System.out.println(Thread.currentThread().getName()+"xxx");
        });
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
                System.out.println(c.await(10,TimeUnit.MILLISECONDS));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        },"t1");
        Thread t2 = new Thread(()->t1.run(),"t2");
        Thread t3 = new Thread(()->t1.run(),"t3");
        //t1.start();
        //t2.start();
        t3.start();
    }
}
