package java8.methodref;

import org.hamcrest.Condition;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *方法引用
 * 1.对象::实例方法
 * 2.类::类方法
 * 3.类::实例方法(见test3,4)
 *
 * 构造器引用
 * 类::new
 *
 * 数组引用
 * 类[]::new
 */

public class Test1 {

    @Test
    public void test1(){
        Consumer<String> con1 = (x)-> System.out.println(x);
        //上下两种形式等价
        Consumer<String> con2 = System.out::println;//方法的参数列表必须相同
    }

    @Test
    public void test2(){
        Consumer<Integer> consumer = test::anInt;//当接受的方法没有返回值时被调用方法可以又放回值
        //当接受方法有返回值时,被带哦用发法必须有返回值且返回值类型要相同
    }

    private static class test{

        public test() {
        }


        public test(String s) {
            System.out.println(s);
        }

        public static int anInt(int i){
            return 1;
        }

        public void ttt(String s,int i){
            System.out.println(s+i);
        }
    }

    @Test
    public void test3 (){
        BiPredicate<String,String> biPredicate1 = (x,y) -> x.equals(y);
        //等价于下面
        BiPredicate<String,String> biPredicate2 = String::equals;
        //当方法参数列表中的参数中第一个参数时方法的调用者,
        // 后面参数作为参数列表时可以用类名表示调用方法的实例对象
    }

    @Test
    public void test4(){
        ttt ttt = test::ttt;
        ttt.ttt(new test(),"sss",1);
    }

    private interface ttt{
        public void ttt(test t,String s,int i);
    }

    @Test
    public void test5(){
        Supplier<test> supplier = test::new;
        System.out.println(supplier.get());

        System.out.println(((Supplier)test::new).get());

        nnn<test> nnn = test::new;//会自动匹配参数列表对应构造器,当没有对应参数列表的构造器时无法通过编译

        System.out.println(nnn.get("sss1"));
    }
    private interface nnn<T>{
        T get(String s);
    }

    @Test
    public void test6(){
        Function<Integer,int[]> supplier = int[]::new;//不仅基本类型
    }
}
