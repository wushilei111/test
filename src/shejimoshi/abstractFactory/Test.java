package shejimoshi.abstractFactory;

public class Test {
    public static void main(String[] args) {
        AbstractFactory abstractFactory1 = new MakeUp1();
        AbstractFactory abstractFactory2 = new MakeUp2();
        abstractFactory1.makeup();
        abstractFactory2.makeup();
    }
}
