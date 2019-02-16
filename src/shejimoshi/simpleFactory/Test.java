package shejimoshi.simpleFactory;

public class Test {
    public static void main(String[] args) {
        Fruit fruit1 = FruitFactory.getApple();
        Fruit fruit2 = FruitFactory.getBanana();
        Fruit fruit3 = FruitFactory.getFruit("Apple");
        Fruit fruit4 = FruitFactory.getFruit("Banana");
        fruit1.eat();
        fruit2.eat();
        fruit3.eat();
        fruit4.eat();
    }
}
