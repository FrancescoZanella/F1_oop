package database;
import domain_classes.User;

import java.sql.*;
import java.util.Arrays;


public class Data extends Thread{
    //ResultSet rs;

    public static void InsertNewUser(User u) throws SQLException {
        Statement statement = null;
        Connection c = null;
        try{
            Class.forName(Utils.JDBC_Driver_SQLite);
            c = DriverManager.getConnection(Utils.JDBC_URL_SQLite);

            statement = c.createStatement();
            statement.executeUpdate("INSERT INTO user VALUES('" + u.getName() + "','" + u.getSurname() + "','" + u.getMail() + "','" +  u.getUsername() + "','" + Arrays.toString(u.getPassword()) + "')");

        } catch(ClassNotFoundException | SQLException e) {
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


   /*public User getSelectedUser() {
        try{
           return new User(rs.getString("name"), rs.getString("surname"), rs.getString("username"), rs.getString("mail"), rs.getString("password"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }*/

}
