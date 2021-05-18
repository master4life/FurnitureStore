package FurnitureStore.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {

    private Connection connection = null;

    private final String URL_TO_DB = "jdbc:sqlite:src/DB/FurnitureStore.db";

    public DBController() throws SQLException {
        connection = DriverManager.getConnection(URL_TO_DB);
    }

    public Connection getConnection() {
        return connection;
    }
}
