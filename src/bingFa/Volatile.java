package bingFa;

public class Volatile {
    public static void main(String[] args) {
        A a=new A();
        for (int i = 0; i <5 ; i++) {
            new Thread(a).start();
        }
    }
}
class A implements Runnable{
    public int i=0;

    @Override
    public synchronized void run() {
        i++;
        System.out.println(i);
    }
}