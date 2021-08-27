package database;

import domain_classes.Driver;
import domain_classes.Squad;
import domain_classes.User;

import java.sql.Connection;
import java.sql.SQLException;

public class DataConstructor extends Data{
    public void InsertNewConstructor(Squad s) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO constructor VALUES('" + s.getName() + "'," + s.getNumber() + ",'" + s.getD1().getName() + "','" + s.getD2().getName() + "','" + s.getD1().getNumber() + "','" + s.getD2().getNumber() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameConstructor(Squad s) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from constructor");
                while (rs.next()) {
                    if (s.getName().equals(rs.getString("name")) && s.getNumber() == rs.getInt("number"))
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

    public void deleteConstructor(Squad s){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM constructor WHERE name = '" + s.getName() + "' and number = " + s.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteAllConstructors(){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM constructor");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public Squad getConstructor(String new_name, int new_number){
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM constructor WHERE number = " + new_number + " and name = '" + new_name + "'");
            if(rs.next()){
                DataDriver d = new DataDriver();
                return new Squad(rs.getString("name"), rs.getInt("number"), d.getDriver(rs.getString("driver_name1"), rs.getInt("number_driver1")), d.getDriver(rs.getString("driver_name2"), rs.getInt("number_driver2")));
            }
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}
