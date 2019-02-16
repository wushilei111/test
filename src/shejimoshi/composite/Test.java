package shejimoshi.composite;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("1");
        Employee employee2 = new Employee();
        employee2.setName("2");
        Employee employee3 = new Employee();
        employee3.setName("3");
        Employee employee4 = new Employee();
        employee4.setName("4");
        Employee employee5 = new Employee();
        employee5.setName("5");
        employee4.add(employee5);
        employee2.add(employee3);
        employee1.add(employee2);
        employee1.add(employee4);
        System.out.println(employee1);
    }
}
