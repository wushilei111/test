package shejimoshi.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employee {
    String name;
    private List<Employee> subordinate = new ArrayList<>();

    public void add(Employee employee){
        subordinate.add(employee);
    }

    public void remove(Employee employee){
        subordinate.remove(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sub = new StringBuilder();
        for (Employee emp:subordinate){
            sub.append(emp.toString("  "));
        }
        return "name='" + name + '\'' +
                "\n" + sub;
    }
    public String toString(String s) {
        StringBuilder sub = new StringBuilder();
        for (Employee emp:subordinate){
            sub.append(emp.toString(s+"  "));
        }
        return s+"name='" + name + '\'' +
                "\n"+ sub;
    }
}
