package shejimoshi.bridge;

public abstract class Pen {
    Color color;
    public Pen(Color color){
        this.color = color;
    }

    abstract void drow();
}
