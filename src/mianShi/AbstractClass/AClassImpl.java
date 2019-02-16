package mianShi.AbstractClass;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AClassImpl extends AClass {
    public static void main(String[] args) {
        System.out.println("Test start");
        System.out.println("Test end");
    }

    @Test
    public void getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///test","root","root");
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
/*        System.out.println("Test start");
        new AClassImpl();
        System.out.println("Test end");*/
    }
}
