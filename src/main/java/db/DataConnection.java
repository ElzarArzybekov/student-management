package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentManagmentSystem";
    private static final String USER =  "postgres";
    private static final String PASSWORD = "321123213";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
