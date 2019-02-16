package mianShi.stringTest;

import mianShi.Sigle;
import org.junit.Test;

public class StringTest {
    @Test
    public void test(){
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        String s4 = new String("a");
        System.out.println("a==s1"+("a"==s1));
        System.out.println("s1==s2"+(s1==s2));
        System.out.println("s3==s4"+(s3==s4));
        s2 = "b";
        System.out.println("s2chenge s1="+s1);
    }
    @Test
    public void test1(){
        String a="abc";
        String b ="abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println(b==d);
    }
}
