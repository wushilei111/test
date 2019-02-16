package thread;

public class VolatileDemo {
    private static int i = 0;
    private boolean isStoped = false;

    public static void main(String[] args) {
        VolatileDemo c= new VolatileDemo();
        new SubThread(c).start();
        i = 1000;
        c.isStoped = true;
    }

    private static class SubThread extends Thread{
        VolatileDemo c;

        public SubThread(VolatileDemo c) {
            this.c = c;
        }

        public void run(){
            while(!c.isStoped){
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }

            System.out.println(i);
        }
    }
}