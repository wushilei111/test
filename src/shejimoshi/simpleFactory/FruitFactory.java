package shejimoshi.simpleFactory;

public class FruitFactory {
    public static Apple getApple(){
        return new Apple();
    }

    public static Banana getBanana(){
        return new Banana();
    }

    public static Fruit getFruit(String fruittype){
        try {
            return (Fruit) Class.forName("shejimoshi.simpleFactory."+fruittype).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("检查水果类型");
            throw new RuntimeException(e);
        }
    }
}
