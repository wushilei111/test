package bingFa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PutGet {

    public static void main(String[] args) {
        PutGet3<Object> putGet1 = new PutGet3<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    putGet1.get();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    putGet1.put(new Object());
                }
            }).start();
        }
    }

    static class PutGet1<O> {
        private final int MAX = 10;
        private final List<Object> list = new LinkedList();

        public synchronized void put(Object o) {
            while (list.size() >= MAX) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(o);
            System.out.println("put now" + list.size());
            this.notifyAll();
        }

        public synchronized void get() {
            while (list.size() <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.get(0);
            list.remove(0);
            System.out.println("get now" + list.size());
            this.notifyAll();
        }
    }

    static class PutGet2<T> {
        private final int MAX = 10;
        private final List<T> list = new LinkedList<>();

        Lock lock = new ReentrantLock();
        Condition put = lock.newCondition();
        Condition get = lock.newCondition();

        public void put(T t) {
            try {
                lock.lock();
                while (list.size() >= MAX) {
                    put.await();
                }
                list.add(t);
                System.out.println("put now" + list.size());
                get.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void get() {
            try {
                lock.lock();
                while (list.size() <= 0) {
                    get.await();
                }
                list.remove(0);
                System.out.println("get now:" + list.size());
                put.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class PutGet3<T> {
        private final BlockingQueue<T> queue = new ArrayBlockingQueue<T>(10);

        public void put(T t) {
            try {
                queue.put(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put now" + queue.size());
        }

        public void get() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get now" + queue.size());
        }
    }
}
