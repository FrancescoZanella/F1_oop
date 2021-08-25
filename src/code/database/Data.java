package database;
import domain_classes.User;
import org.sqlite.core.DB;

import java.sql.*;


public class Data extends Thread{
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

    public void InsertNewUser(User u) throws SQLException {

        try{
            startConnection();
            statement.executeUpdate("INSERT INTO user VALUES('" + u.getName() + "','" + u.getSurname() + "','" + u.getMail() + "','" +  u.getUsername() + "','" + u.getPassword() + "')");

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                    c.close();
                }

        }
    }


    public boolean sameUser(String new_username) {
        try {
                startConnection();
            try {
                rs = statement.executeQuery("Select * from user");
                while (rs.next()) {
                    if (new_username.equals(rs.getString("username")))
                        return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
                closeConnection();
            }
        return false;
    }

    public boolean correctLogin(String new_username, String new_password){
        try{
            startConnection();
            try{
                rs = statement.executeQuery("Select * from user " +
                        "where username = '" + new_username +
                        "' and password = '" + new_password + "'");

                return new_username.equals(rs.getString("username")) && new_password.equals(rs.getString("password"));
            } catch(SQLException e){
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return false;
    }




}
