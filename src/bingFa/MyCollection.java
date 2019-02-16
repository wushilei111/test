package bingFa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyCollection {
    volatile List list = new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                myCollection.add(new Object());
                System.out.println("asd");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true){
                if(myCollection.size()==5)
                    break;
            }
            System.out.println("end");
        }).start();
    }
}
