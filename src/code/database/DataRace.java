package database;

import domain_classes.Driver;
import domain_classes.Race;

import java.sql.SQLException;

public class DataRace extends Data {
    public void InsertNewDriver(Race d) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO race VALUES('" + d.getName() + "','" + d.getNation() + "'," + d.getKm() + ",'" + d.getRace_day() + "','" + d.getQualification_day() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameRace(Race r) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from race");
                while (rs.next()) {
                    if (r.getRace_day() == rs.getDate("race_day") && r.getName().equals(rs.getString("name")) && r.getNation().equals(rs.getString("nation")))
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

    public void deleteRace(Race r){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM race WHERE(name = '" + r.getName() + "' and nation = '" + r.getNation() + "' and race_day = '" + r.getRace_day() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteAllRaces(){
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM race");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
