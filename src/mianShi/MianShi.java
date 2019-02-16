package mianShi;

import org.junit.Test;

import java.util.concurrent.*;

public class MianShi {

    @Test
    public void autoIncriement(){
        int i = 1;
        i = i++;
        int j = i++;
        int k = i+ ++i * i++;
        System.out.println("i = "+i);
        System.out.println("j = "+j);
        System.out.println("k = "+k);
    }
    @Test
    public void autoIncrement2(){
        int i=5;
        i+=i--;
        System.out.println(i);
    }
    @Test
    public void single() throws ExecutionException, InterruptedException {
        System.out.println(Single4.getSingle());
        Callable<Single4> callable = new Callable<Single4>() {
            @Override
            public Single4 call() throws Exception {
                return Single4.getSingle();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future1 = executorService.submit(callable);
        Future future2 = executorService.submit(callable);
        Single4 single41 = (Single4) future1.get();
        Single4 single42 = (Single4) future1.get();
        System.out.println(single41==single42);
    }
}
