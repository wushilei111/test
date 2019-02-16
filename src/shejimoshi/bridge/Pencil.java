package shejimoshi.bridge;

public class Pencil extends Pen {
    public Pencil(Color color) {
        super(color);
    }

    @Override
    void drow() {
        color.drowColor("铅笔");
    }
}
