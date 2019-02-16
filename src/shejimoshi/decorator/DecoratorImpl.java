package shejimoshi.decorator;

public class DecoratorImpl extends Decorator {
    public DecoratorImpl(InterFace interFace) {
        super(interFace);
    }

    @Override
    public void simpel() {
        super.simpel();
        System.out.println("额外功能");
    }
}
