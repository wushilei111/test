package shejimoshi.abstractFactory;

public class MakeUp1 implements AbstractFactory {
    @Override
    public void makeup() {
        A a = new A1();
        B b = new B1();
        a.show();
        b.show();
    }
}
