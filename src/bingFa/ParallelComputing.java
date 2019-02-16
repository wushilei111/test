package bingFa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        MyTask m1 = new MyTask(1,60000);
        MyTask m2 = new MyTask(60001,110000);
        MyTask m3 = new MyTask(110001,150000);
        MyTask m4 = new MyTask(150001,180000);
        MyTask m5 = new MyTask(180001,190000);
        MyTask m6 = new MyTask(190001,200000);
        Future<List<Integer>> f1 = service.submit(m1);
        Future<List<Integer>> f2 = service.submit(m2);
        Future<List<Integer>> f3 = service.submit(m3);
        Future<List<Integer>> f4 = service.submit(m4);
        Future<List<Integer>> f5 = service.submit(m5);
        Future<List<Integer>> f6 = service.submit(m6);

        long start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        f5.get();
        f6.get();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    static class MyTask implements Callable<List<Integer>> {
        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(start,end);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    static ArrayList<Integer> getPrime(int start,int end){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=start;i<end;i++)
            if (isPrime(i))
                list.add(i);
        return list;
    }
}
