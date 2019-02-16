package bingFa;

import java.util.concurrent.*;

public class FeatureTaskT {
    public static void main(String[] args) {
        ExecutorService exectorService =  Executors.newFixedThreadPool(1);

        Future<Integer> futureTask = exectorService.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            return 1;
        });
        System.out.println(futureTask.isDone());
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
