package database;

import domain_classes.League;
import domain_classes.User;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataLeague extends Data {

    public void insertNewLeague(League l) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO league(name, invitationcode, leaguetype, leaguelength) VALUES('" + l.getLeagueName() + "','" + l.getInviteCode() + "','" + l.getLeagueType() + "','" + l.getLeagueLenght() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameLeague(League l) {
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from league");
                while (rs.next()) {
                    if (l.getInviteCode() == rs.getInt("invitationcode"))
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

    public int numberOfLeaguePerUser(User u) {
        int c = 0;
        try {
            startConnection();
            try {
                for (int i = 1; i < 9; i++) {
                    rs = statement.executeQuery("Select * from league" +
                            "where name_user" + i + " = '" + u.getUsername() + "'");
                    while (!rs.wasNull()) {
                        c++;
                        rs.next();
                    }
                }
                return c;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return c;
    }

    public List<League> LeaguesPerUser(User u){
        List<League> l = new LinkedList<>();
        try {
            startConnection();
            try {
                for (int i = 1; i < League.getMaxTeamsPerUser() + 1; i++) {
                    rs = statement.executeQuery("Select * from league" +
                            "where name_user" + i + " = '" + u.getUsername() + "'");
                    while (!rs.wasNull()) {
                        /*League tmp = new League(rs.getString("leaguename"), rs.getInt("invitationcode"), rs.getBoolean("leaguetype"),
                                rs.getInt("leaguelength"));*/
                        rs.next();
                    }
                }
                return l;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return null;
    }

}
