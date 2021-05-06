import java.sql.*;


public class Test {
    public static void main(String[] args) throws SQLException {

       SweetnessesDao sweetnessesDao = new SweetnessesDao(DriverManager.getConnection("jdbc:mysql://localhost/MyBase", "root", "6706598"));

//       System.out.println(sweetnessesDao.findByName("баунти"));
//
       //Sweetness sweetness = new Sweetness("БОБ", 33,10000);
       //sweetnessesDao.create(sweetness);
        System.out.println(sweetnessesDao.findAll());
//        Sweetness sweetness = new Sweetness("Баунти",500,1500);
//        sweetnessesDao.update(sweetness);
//        System.out.println(sweetnessesDao.update(sweetness));



    }

}
