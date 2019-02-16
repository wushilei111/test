package mianShi.classLoder;

import org.junit.Test;

public class Father {
    static int i = m();
    int j = n();

    {
        System.out.println(this+""+this.n());
        System.out.println("f5");
    }
    protected int n() {
        System.out.println("f4");
        return 2;
    }

    public Father(){
        System.out.println("f3");
    }
    static {
        System.out.println("f1");
    }

    public static int m(){
        System.out.println("f2");
        return 1;
    }

    @Test
    public void testSingleLoad(){
        LoadSingle single = LoadSingle.getSingle();
        System.out.println("after instence a="+single.a);
        System.out.println("after instence b="+single.b);
    new StringBuilder("a").toString();
    }
}
