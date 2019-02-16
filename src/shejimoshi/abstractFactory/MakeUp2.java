package shejimoshi.abstractFactory;

public class MakeUp2 implements AbstractFactory {
    @Override
    public void makeup() {
        A a = new A2();
        B b = new B2();
        a.show();
        b.show();
    }
}
