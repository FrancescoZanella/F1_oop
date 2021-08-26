package database;

import domain_classes.User;
import java.sql.SQLException;

public class DataUser extends Data{

    public void InsertNewUser(User u) throws SQLException {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO user VALUES('" + u.getName() + "','" + u.getSurname() + "','" + u.getMail() + "','" + u.getUsername() + "','" + u.getPassword() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
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

    public boolean correctLogin(String new_username, String new_password) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from user " +
                        "where username = '" + new_username +
                        "' and password = '" + new_password + "'");

                return new_username.equals(rs.getString("username")) && new_password.equals(rs.getString("password"));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
