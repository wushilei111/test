package mianShi.classLoder;

import org.junit.Test;

public class LoadSingle {
    private static LoadSingle single = new LoadSingle();
    static int a;
    static int b=set();
    private LoadSingle(){
        System.out.println("pre set a="+a);
        a++;
        System.out.println("after set a="+a);
        System.out.println("pre set b="+b);
        b++;
        System.out.println("after set b="+b);
    }

    private static int set(){
        System.out.println("pre in set b="+b);
        return 0;
    }

    public static LoadSingle getSingle(){
        return single;
    }
}
