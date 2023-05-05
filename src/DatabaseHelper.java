import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:app.db";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS items (id INTEGER PRIMARY KEY, item TEXT NOT NULL);";

        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
