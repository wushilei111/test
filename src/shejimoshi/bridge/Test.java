package shejimoshi.bridge;

public class Test {
    public static void main(String[] args) {
        Color c1 = new Red();
        Pen pen1 = new Pencil(c1);
        pen1.drow();
    }
}
