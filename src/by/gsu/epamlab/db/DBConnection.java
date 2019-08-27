package by.gsu.epamlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/results?serverTimezone=UTC";
    private static final String USER = "jse";
    private static final String PASSWORD = "jse";
    private static Connection cn;
    static {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver BD not founds \t=>\t\n"+e.getMessage());}
    }

    private DBConnection() {
    }

    public static Connection getNewConnection() throws SQLException {
        if (cn == null) {
            cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        return cn;
    }
}
