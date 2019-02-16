package thread;

import mianShi.Sigle;
import org.junit.Test;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Static {

    public static void main(String[] args) {
        /*II ii = new II();
        Thread thread1 = new IncrementThread(ii);
        Thread thread2 = new IncrementThread(ii);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();*/
        Thread thread1 = new IncrementThread();
        thread1.start();
        ((IncrementThread) thread1).j = 10;
    }
    @Test
    public void test(){
        Thread thread1 = new IncrementThread();
        thread1.start();
        ((IncrementThread) thread1).j = 10;
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class IncrementThread extends Thread{
    public static int i=0;
    public II ii;
    public int j;
    public IncrementThread() {
    }

    public IncrementThread(II ii) {
        this.ii = ii;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this.getName()+(++j));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class II{
    public int i =0;
}