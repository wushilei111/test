import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class lamada {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(A::s);
//下面的方法和上面等价的
        Consumer<String> methodParam = A::s; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }


}

class A {
    public static void s(String s) {
        System.out.println(s);
    }
}
