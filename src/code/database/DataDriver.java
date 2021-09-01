package database;

import domain_classes.Driver;
import domain_classes.Squad;
import domain_classes.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataDriver extends Data{

    public void InsertNewDriver(Driver d) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO driver VALUES('" + d.getName() + "'," + d.getNumber() + ",'" + d.getAge() + "', 0, 0, 0, 0, 0)");
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

    public Driver getDriver(String new_name, int new_number){
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM driver WHERE number = " + new_number + " and name = '" + new_name + "'");
            if(rs.next())
                return new Driver(rs.getString("name"), rs.getInt("age"), rs.getInt("number"), rs.getInt("f1points"), rs.getInt("fantaf1points"), rs.getFloat("fantavalue"), rs.getString("race_position"), rs.getString("qualifying_position"));
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<Driver> getAllDrivers() {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM driver ORDER BY name");
            ArrayList<Driver> d = new ArrayList<>();
            while(rs.next())
                d.add(new Driver(rs.getString("name"), rs.getInt("age"), rs.getInt("number"), rs.getInt("f1points"), rs.getInt("fantaf1points"), rs.getFloat("fantavalue"), rs.getString("race_position"), rs.getString("qualifying_position")));
            return d;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public void setRacePosition(String new_name, int new_number, String position){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET race_position = '" + position +
                    "' where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setQualifyingPosition(String new_name, int new_number, String position){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET qualifying_position = '" + position +
                    "' where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setAllValues(String new_name, int new_number, int fantaf1points, int f1points, double fantavalue){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET fantaf1points = " + fantaf1points + ", f1points = " + f1points + ", fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setFantaValue(String new_name, int new_number, double fantavalue){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET fantavalue = " + fantavalue +
                    " where name = '" + new_name + "' and number = " + new_number);
            DataTeam dt = new DataTeam();
            dt.setBudget(new_name, new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setF1Points(String new_name, int new_number, int f1points){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET f1points = f1points + " + f1points +
                    " where name = '" + new_name + "' and number = " + new_number);
            DataConstructor dc = new DataConstructor();
            dc.setF1Points(Squad.getConstructorByDriver(new_name, new_number).getName(), Squad.getConstructorByDriver(new_name, new_number).getNumber(), f1points);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void setFantaF1Points(String new_name, int new_number, int fantaf1points){
        try {
            startConnection();
            statement.executeUpdate("UPDATE driver SET fantaf1points = fantaf1points + " + fantaf1points +
                    " where name = '" + new_name + "' and number = " + new_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        DataTeam dt = new DataTeam();
        dt.setFantaPointsTeam(new_name, new_number);
    }


}
