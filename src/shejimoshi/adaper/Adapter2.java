package shejimoshi.adaper;

public class Adapter2 implements Target{
    private Adaptee adaptee;

    public Adaptee getAdaptee() {
        return adaptee;
    }

    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void a(){
        adaptee.a();
    }

    public void b(){
        System.out.println("funcation b");
    }
}
