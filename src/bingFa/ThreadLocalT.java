package bingFa;

import java.util.concurrent.TimeUnit;

public class ThreadLocalT {

    public static void main(String[] args) {
    ThreadLocal<Person> threadLocal = new ThreadLocal<>();
        new Thread(()->{
            threadLocal.set(new Person());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
    }
}
