package bingFa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile2 {
     boolean running = true;
    void m(){
        System.out.println("m start");
        while(running){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("???");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Volatile2 volatile2 = new Volatile2();
        new Thread(volatile2::m).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatile2.running = false;
    }
    static class vvv {
        AtomicInteger c = new AtomicInteger(0);

        void add(){
            for (int i = 0; i < 10000; i++) {
                if (c.get()<1000)
                c.incrementAndGet();
            }
        }
        public static void main(String[] args) {
            List<Thread> list = new ArrayList();
            vvv vvv = new vvv();
            for (int i = 0; i < 10; i++) {

                list.add(new Thread(vvv::add));
            }
            list.forEach((o)->o.start());
            list.forEach((o)->{
                try {
                    o.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(vvv.c);
        }
        @Test
        void test(){

        }
    }
}
