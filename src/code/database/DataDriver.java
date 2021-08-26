package database;

import domain_classes.Driver;
import domain_classes.User;

import java.sql.SQLException;

public class DataDriver extends Data{

    public void InsertNewDriver(Driver d) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO driver VALUES('" + d.getName() + "'," + d.getNumber() + ",'" + d.getAge() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameDriver(Driver d) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from driver");
                while (rs.next()) {
                    if (d.getNumber() == rs.getInt("driver") && d.getName().equals(rs.getString("name")))
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

    public void deleteDriver(Driver d){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM driver WHERE(name = '" + d.getName() + "' and number = " + d.getNumber() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteAllDrivers(){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
