package shejimoshi.construct;

public class Test {
    public static void main(String[] args) {
        Builder b = new BuilderImpl();
        Director d = new Director(b);
        d.build();
        System.out.println(b.getModel());
    }
}
