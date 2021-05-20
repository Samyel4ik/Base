import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SweetnessesDao {
    Connection connection;

    public SweetnessesDao(Connection connection) {
        this.connection = connection;
    }

    public List<Sweetness> findAll() throws SQLException {

        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT*FROM Sweetnesses")) {

            List<Sweetness> list = new ArrayList<Sweetness>();
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                int prise = resultSet.getInt("prise");
                int calories = resultSet.getInt("calories");
                list.add(new Sweetness(name, calories, prise));
            }
            return list;
        }
    }

    public Sweetness create(Sweetness sweetness) throws SQLException {
        try (Statement statement = this.connection.createStatement()) {

            String name = sweetness.getName();
            int prise = sweetness.getPrise();
            int calories = sweetness.getCalories();

            String command_SQL = String.format("INSERT Sweetnesses (name,prise,calories) VALUES (a='%s' ,b=%d,c=%d)", name, prise, calories);
            statement.executeUpdate(command_SQL);
            return sweetness;
        }
    }

    public Sweetness findByName(String name) throws SQLException {
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sweetnesses WHERE name = " + "'" + name + "'")) {

            while (resultSet.next()) {

                String nameSw = resultSet.getString("name");
                int prise = resultSet.getInt("prise");
                int calories = resultSet.getInt("calories");
                Sweetness sweetness = new Sweetness(nameSw, calories, prise);
                return sweetness;
            }

            return null;
        }
    }

    public Sweetness update(Sweetness sweetness) throws SQLException {
        try (Statement statement = this.connection.createStatement()) {

            String command_SQL = String.format("UPDATE sweetnesses SET prise = a = %d ,b=%d", sweetness.getPrise(), sweetness.getCalories());
            statement.executeUpdate(command_SQL);

            return sweetness;
        }
    }

    public void delete(String sweetnessName) throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            String command_SQL = String.format("delete from Sweetnesses where name = a = '%s'", sweetnessName);

            statement.executeUpdate(command_SQL);
        }
    }
}
