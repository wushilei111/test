package java8.optional;

import org.junit.Test;

import java.util.Optional;

public class Test1 {
    /**
     * Optional类被设计用于方便的定位空指针异常,在java.util包下,是一个容器
     *
     * 常用方法:
     *      Optional.of(T t) 创建一个Optional类的实例 若T为空则抛出空指针异常
     *      Optional.empty() 创建一个空的Optional实例
     *      Optional.Nullable(T t) 若t不为空创建一个Optional实例,为空则创建一个Optional空实例
     *      Optional.isPresent() 判断是否含有值
     *      orElse(T t) 如果有值则返回该值,否则返回T
     *      orElseGet(Supplier s) 如果有值则返回该值,否则返回s生成的值
     *      map(Function f) 如果有值这用f对其处理并包装为一个Optional返回,否则返回一个空Optional
     *      falatMap(Function f) 与map类似但要求f方法返回Optional(即需要在f中对返回值进行Optional包装)
     */
    @Test
    public void test1(){
        Optional<Integer> o = Optional.of(12);
        o.map((x)->x*3);
        o.flatMap((x)->Optional.of(x*3));
    }
}
