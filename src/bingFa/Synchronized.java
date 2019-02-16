package bingFa;

public class Synchronized {
    public synchronized void m1() throws InterruptedException {
        System.out.println("m1");
        Thread.sleep(10000);

    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("m2");
    }

    public static void main(String[] args) {
        Synchronized s = new Synchronized();
        new Thread(()-> {
            try {
                s.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                s.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
