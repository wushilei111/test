package java8.annotion;

import org.junit.Test;

import java.lang.reflect.Method;

public class AnnotionTest {
    /**
     * 想要定义重复注解（再同一个目标上多次标记同一个注解），需要创建一个注解容器（也是注解），再想要成为
     * 重复注解的注解类上标注@Repetable（容器注解类.class）
     *
     * 类型注解,用再参数或变量的类型前,用与对参数或变量进行操作
     */
    @Test
    public void test1() throws NoSuchMethodException {
        Class<AnnotionTest> cla = AnnotionTest.class;
        Method m = cla.getMethod("xxx");
        TestAnnotion[] t = m.getAnnotationsByType(TestAnnotion.class);
        for (TestAnnotion ta:t
             ) {
            System.out.println(ta.value());
        }
    }

    @TestAnnotion("mmp")
    @TestAnnotion
    public void xxx(){

    }
}
