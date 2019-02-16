package shejimoshi.duty;

public abstract class Duty {
    Duty next;
    public abstract void doSomething();//处理方法

    public Duty getNext() {
        return next;
    }

    public void setNext(Duty next) {
        if(this.next!=null)
            this.next.setNext(next);
        this.next = next;
    }
}
