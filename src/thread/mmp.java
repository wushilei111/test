package thread;

public class mmp {
    private static volatile boolean bChanged = false;
    private static int i;
    private static int j;
    public static void main(String args[]) throws InterruptedException {
        new Thread(){
            public void run(){
                for (;;){
                    System.out.println(i+++","+j+bChanged);
                    if (bChanged){
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();
        Thread.sleep(100);
        bChanged=!bChanged;
        j=10;
        /*new Thread(){
            public void run() {
                for (;;){
                    System.out.println(i++);
                    bChanged=!bChanged;
                }
            }
        }.start();*/
    }
}
