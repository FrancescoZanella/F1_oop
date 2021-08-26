package database;

import domain_classes.User;
import org.sqlite.core.DB;

import java.sql.*;


public class Data extends Thread {
    ResultSet rs;
    Statement statement = null;
    Connection c = null;

    public void startConnection() {
        try {
            Class.forName(Utils.JDBC_Driver_SQLite);
            c = DriverManager.getConnection(Utils.JDBC_URL_SQLite);
            statement = c.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
