package java8.interfaceDefault;

import org.junit.Test;

public class Test1 {
    @Test
    public void test1(){
        new TestInterface(){

            @Override
            public void show2() {

            }
        }.show();
    }

    @Test
    public void test3(){
        TestInterface.show3();//接口中还可以有静态方法
    }

    @Test
    public void test2(){
        new TestSubClass().show();//当子类继承的父类与实现的接口中由相同方法头的方法时调用类中的方法
        new TestSubClass().show2();//如果父类中有与实现接口中抽象方法方法头相同的方法时,子类可以选择不实现此方法
        new TestSubClass2().show();//如果实现多个接口,其中一个接口中有一个方法是默认方法,且在其他接口中有相同方法(无论是不是默认方法)
        // 则实现类必须重写此方法以解决冲突
    }
}
