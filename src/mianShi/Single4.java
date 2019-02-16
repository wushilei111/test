package mianShi;

import java.util.concurrent.locks.ReentrantLock;

public class Single4 {
    private static Single4 single;

    private Single4() {
    }
    public static Single4 getSingle() throws InterruptedException {
        synchronized (Single4.class) {
            Thread.sleep(10000);
            return single != null ? single : (single = new Single4());
        }
    }
}
