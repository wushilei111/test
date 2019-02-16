package shejimoshi.bridge;

public class FountainPen extends Pen {
    public FountainPen(Color color) {
        super(color);
    }

    @Override
    void drow() {
        color.drowColor("钢笔");
    }
}
