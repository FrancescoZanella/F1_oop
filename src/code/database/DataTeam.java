package database;

import domain_classes.Abstract_f1_item;
import domain_classes.Team;
import domain_classes.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class DataTeam extends Data {

    public void insertNewTeam(Team t, User u) {
        try {
            startConnection();
            StringBuffer sb = new StringBuffer();
            StringBuffer sbc = new StringBuffer();
            for (Abstract_f1_item i : t.getTeamDrivers().values()) {
                if (i.getNumber() < 100) {
                    sb.append(",'");
                    sb.append(i.getName());
                    sb.append("','");
                    sb.append(i.getNumber());
                    sb.append("'");
                }
                else{
                    sbc.append(",'");
                    sbc.append(i.getName());
                    sbc.append("','");
                    sbc.append(i.getNumber());
                    sbc.append("')");
                }
            }
            statement.executeUpdate("INSERT INTO team(teamname, name_user, driver_name1, number_driver1, " +
                    "driver_name2, number_driver2, driver_name3, number_driver3, driver_name4, number_driver4, driver_name5, number_driver5," +
                    "constructor_name, number_constructor) VALUES('" + t.getTeamName() + "','" + u.getUsername() + sb + sbc);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void deleteTeam(Team t, User u){
        try {
            startConnection();
            StringBuffer sb = new StringBuffer();
            StringBuffer sbc = new StringBuffer();
            statement.executeUpdate("DELETE FROM team WHERE(teamname = '" + t.getTeamName() + "' and name_user = '" + u.getUsername() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public boolean sameTeam(Team t, User u) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from team");
                while (rs.next()) {
                    if (u.getUsername().equals(rs.getString("username")) && t.getTeamName().equals(rs.getString("teamname")))
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
}
