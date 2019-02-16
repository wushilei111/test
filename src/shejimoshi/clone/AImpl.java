package shejimoshi.clone;

public class AImpl implements A {

    private String string;
    @Override
    public A clone() {
        A a = new AImpl();
        ((AImpl) a).string = this.string;
        return a;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
