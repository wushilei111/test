package mianShi;

public class Single5 {
    private Single5(){}
    private static class SingleFactory{
        private static final Single5 single = new Single5();
    }
    public static Single5 getInstance(){
        return SingleFactory.single;
    }
}
