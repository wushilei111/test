package java8.interfaceDefault;

public interface TestInterface {

    static void show3(){
        System.out.println("this is a static function in interface");
    }

    default void show(){//接口默认方法是实例方法
        System.out.println("this is a default function in interface"+this);
    }
    void show2();
}
