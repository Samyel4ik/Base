import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SweetnessesDao {
    Connection connection;

    public SweetnessesDao(Connection connection) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/MyBase", "root", "6706598");
    }

    public List<Sweetness> findAll() throws SQLException {
        List<Sweetness> list = new ArrayList<Sweetness>();
        Statement statement = this.connection.createStatement();
        String command_SQL = "SELECT*FROM Sweetnesses";
        ResultSet resultSet = statement.executeQuery(command_SQL);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            int prise = resultSet.getInt("prise");
            int calories = resultSet.getInt("calories");
            list.add(new Sweetness(name, calories, prise));
        }

        return list;
    }

    public Sweetness create(Sweetness sweetness) throws SQLException {
        Statement statement = this.connection.createStatement();
        String name = sweetness.getName();
        int prise = sweetness.getPrise();
        int calories = sweetness.getCalories();

        String command_SQL = "INSERT Sweetnesses (name,prise,calories) VALUES (" + "'" + name + "'" + "," + prise + "," + calories + ")";
        statement.executeUpdate(command_SQL);
        return sweetness;
    }

    public Sweetness findByName(String name) throws SQLException {
        Statement statement = this.connection.createStatement();

        String command_SQL = "SELECT * FROM sweetnesses WHERE name = " + "'" + name + "'";
        ResultSet resultSet = statement.executeQuery(command_SQL);

        while (resultSet.next()) {

            String nameSw = resultSet.getString("name");
            int prise = resultSet.getInt("prise");
            int calories = resultSet.getInt("calories");
            Sweetness sweetness = new Sweetness(nameSw, calories, prise);
            return sweetness;
        }

        return null;
    }

    public Sweetness update(Sweetness sweetness) throws SQLException {
        Statement statement = this.connection.createStatement();
        String command_SQL = "UPDATE sweetnesses SET prise = " + sweetness.getPrise() + ", calories = " + sweetness.getCalories();
        statement.executeUpdate(command_SQL);

        return sweetness;

    }

    public void delete(String sweetnessName) throws SQLException {
        Statement statement = this.connection.createStatement();
        String command_SQL = "delete from Sweetnesses where name = " + "'" + sweetnessName + "'";

        statement.executeUpdate(command_SQL);

    }
}
