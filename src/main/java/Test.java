import java.sql.*;


public class Test {
    public static void main(String[] args) throws SQLException {

        SweetnessesDao sweetnessesDao = new SweetnessesDao(DriverManager.getConnection("jdbc:mysql://localhost/MyBase", "root", "6706598"));

        //Sweetness sweetness = new Sweetness("БОБ", 33,10000);
        // Sweetness sweetness = new Sweetness("Баунти",500,1500);
        System.out.println(sweetnessesDao.findAll());
    }

}
