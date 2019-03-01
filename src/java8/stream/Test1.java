package java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test1 {
        Stream<String> stream = Arrays.asList(new String[]{"aaa", "bbb","aaa", "ccc"}).stream();
    @Test
    public void test1(){
        //filter过滤
        //linit截断,限制数量,截取前n个,limit与filter的相对位置不同会产生不同的结果
        //skip跳过前n个,与limit和filter的相对位置不同会产生不同的结果
        //distinc()通过hashcode与equals比较

        Stream stream2 =  stream.skip(2).filter((s)->{
           // System.out.println("do equals");
           return s.equals("aaa");
        });//中间操作不会产生任何行为,而是再进行终止(取出如forEach)操作时动态的进行操作
        //Stream stream3 = stream.filter((s)->s.equals("aaa"));
        //对一个流任何操作(中间,终结)不能进行两次,任何Stream类中的方法会返回一个新的Stream旧的Stream不能再进行任何操作
        //System.out.println("do filter");
        stream2.forEach(System.out::println);//在这里对stream中的值循环判断,符合stream2的过滤条件则
        // 执行forEach中的行为,否者就不执行
        //stream2.forEach(System.out::println);抛出异常,流对象只能进行一次终止操作

    }

    @Test
    public void test2(){
        Stream<Integer> stream = Stream.iterate(1,(x)->{
            System.out.println("create");
            return x;
        });//无限流每用到一个创建一个
        System.out.println("============================");
        stream = stream.limit(10);
        System.out.println("============================");
        stream.forEach(System.out::println);
    }

    @Test
    public void test3(){
        Stream stream2 = stream.map((x)->x+"a");//根据一定规则生成新元素替代旧元素
        stream2.forEach(System.out::println);
        //flatmap与map不同在于当map中的方法返回一个流时,map得到的一个存有流的流(Stream<Stream<T>>)
        //而flatmap是将返回的流连接起来得到的是一个简单的流(Stream<T>)
    }

    @Test
    public void test4(){
        /**拍序查找 终止操作（返回值类型不是流的方法）
         *
         * allMatch 流中所有元素判定都为true返回true
         * anyMatch 流中任一元素判定为true就返回true
         * noneMatch 流中所有元素判定为false则返回true
         * findFirst 返回流中第一个元素返回值类型为Optional<T>
         * findAny 返回流中任意一个元素返回值类型为Optional<T>
         * count 返回流中元素数量
         * max 返回流中最大元素 要给定比较器 返回值类型为Optional<T>
         * min 返回流中最小元素 要给定比较器 返回值类型为Optional<T>
         */
    }

    @Test
    public void test5(){
        /**
         * reduce (归纳)传入起始值(在第一次运算中作为第一个参数与第一个元素进行运算的元素,此参数为可选项,
         * 但缺省此参数时返回结果为返回值类型为Optional<T>,传入此参数时返回值类型为元素类型),
         * 和一个二元运算(接受两个同类型参数,返回一个同类型参数),由前到后依次进行运算,
         * 将前一一次结果当成第一个参数,下一个元素当成第二个参数,当没有元素后返回结果
         */
    }

    @Test
    public void test6(){
        /**
         * 收集
         * collect 将流中元素转换为集合返回,需要传入Collector接口,但可以用Collectors中静态方法带替
         */
        new ArrayList<Integer>().stream().collect(Collectors.toList());
        new ArrayList<Integer>().stream().collect(Collectors.toCollection(HashSet::new));
        new ArrayList<Integer>().stream().collect(Collectors.groupingBy((x)->x));//Function<? super T(参数类型,stream中元素),
        // ? extends K (返回值类型,分组依据)> classifier
        //返回值为Map<K,List<T>>
        new ArrayList<Integer>().stream().collect(Collectors.groupingBy((x)->x,Collectors.groupingBy((x)->x)));//多级分组

        new ArrayList<Integer>().stream().collect(Collectors.partitioningBy((x)->true));//分区 boolean fa(T t);
        // 分区,返回true的为一组返回false的为一组
        LongStream.rangeClosed(1,1111111111L).parallel()//切换为并行流(自动切分任务)
                .sequential();//切换为串行流(单线程)


    }
}
