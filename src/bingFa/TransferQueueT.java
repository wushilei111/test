package bingFa;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueT {
    static TransferQueue transferQueue = new LinkedTransferQueue();//继承于阻塞队列，相对与普通队列多了一个transfer方法

    public static void main(String[] args) {
        /*new Thread(()->{
            try {
                System.out.println(transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
        try {
            transferQueue.transfer("aaa");//  将对象直接交给消费者线程，如果没有请求对象的消费者线程者阻塞等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                System.out.println(transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
