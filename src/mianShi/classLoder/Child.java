package mianShi.classLoder;

public class Child extends Father {

    static {
        System.out.println("c1");
    }
    public Child(){
        super();
        System.out.println("c3");
    }
    static int i = m();
    int j = n();

    {
        System.out.println("c5");
    }
    public int n() {
        System.out.println("c41");
        return 1;
    }
    public static int m(){
        System.out.println("c2");
        return 1;
    }

    public static void main(String[] args) {
        new Child();
    }
}
