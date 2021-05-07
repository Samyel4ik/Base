import java.sql.*;
import java.util.Formatter;


public class Test {
    public static void main(String[] args) throws SQLException {

        SweetnessesDao sweetnessesDao = new SweetnessesDao(DriverManager.getConnection("jdbc:mysql://localhost/MyBase", "root", "6706598"));

        //Sweetness sweetness = new Sweetness("БОБ", 33,10000);
        // Sweetness sweetness = new Sweetness("Баунти",500,1500);
      //  System.out.println(sweetnessesDao.findAll());

        double x = 1000.0 / 3.0;
        System.out.println("Строка без форматирования: " + x);

        Formatter formatter = new Formatter();
        formatter.format("Строка c форматированием: %.2f%n", x);
        formatter.format("Строка c форматированием: %8.2f%n", x);
        formatter.format("Строка c форматированием: %16.2f%n", x);
        System.out.println(formatter);
    }

}
