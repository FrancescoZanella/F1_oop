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
            statement.executeUpdate("INSERT INTO constructor VALUES('" + s.getName() + "'," + s.getNumber() + ",'" + s.getD1().getName() + "','" + s.getD2().getName() + "','" + s.getD1().getNumber() + "','" + s.getD2().getNumber() + "', 0, 0, 0)");
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
            statement.executeUpdate("DELETE FROM constructor(name, number) WHERE name = '" + s.getName() + "' and number = " + s.getNumber());
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

    public void setAllValues(String new_name, int new_number, int fantaf1points, int f1points, float fantavalue){
        try {
            startConnection();
            rs = statement.executeQuery("UPDATE constructor SET fantaf1points = " + fantaf1points + ", f1points = " + f1points + ", fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setFantaValue(String new_name, int new_number, float fantavalue){
        try {
            startConnection();
            rs = statement.executeQuery("UPDATE constructor SET fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setF1Points(String new_name, int new_number, int f1points){
        try {
            startConnection();
            rs = statement.executeQuery("UPDATE constructor SET f1points = " + f1points +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setFantaF1Points(String new_name, int new_number, int fantaf1points){
        try {
            startConnection();
            rs = statement.executeQuery("UPDATE constructor SET fantaf1points = fantaf1points + " + fantaf1points +
                    " where name = '" + new_name + "' and number = " + new_number);
            DataTeam dt = new DataTeam();
            dt.setFantaPointsTeam(new_name, new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }



}
