package shejimoshi.bridge;

public class BrushPen extends Pen {
    public BrushPen(Color color) {
        super(color);
    }

    @Override
    void drow() {
        color.drowColor("毛笔");
    }
}
