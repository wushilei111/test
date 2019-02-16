package shejimoshi.clone;

public class Test {
    public static void main(String[] args) {
        AImpl a1 = new AImpl();
        AImpl a2 = (AImpl) a1.clone();
        System.out.println(a1==a2);
        System.out.println( a1.getString()==a2.getString());
    }
    @org.junit.Test
    public void test(){
        AImpl a1 =new AImpl();
        Manager.addA("a1",a1);
        AImpl a2=null;
        try {
            a2 = (AImpl) Manager.getA("a1").clone();
            Manager.addA("a2",a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a2 == a1);
        try {
            System.out.println(Manager.getA("a2") == Manager.getA("a1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
