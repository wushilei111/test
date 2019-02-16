package bingFa;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueT {
    static DelayQueue delayQueue = new DelayQueue();

    static class Mytask implements Delayed {
        long delay;

        public Mytask(long delay) {
            this.delay = delay;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delay - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Mytask{" +
                    "delay=" + delay +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        Mytask t1 = new Mytask(now + 1000);
        Mytask t2 = new Mytask(now + 1800);
        Mytask t3 = new Mytask(now + 800);
        Mytask t4 = new Mytask(now + 13000);
        Mytask t5 = new Mytask(now + 16000);

        delayQueue.put(t1);
        delayQueue.put(t2);
        delayQueue.put(t3);
        delayQueue.put(t4);
        delayQueue.put(t5);

        System.out.println(delayQueue);

        for (int i = 0; i < 5; i++) {
            System.out.println(delayQueue.take());
        }
    }
}
