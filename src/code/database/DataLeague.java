package database;

import domain_classes.League;
import domain_classes.Team;
import domain_classes.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DataLeague extends Data {

    public void insertNewLeague(League l) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO league (leaguename, invitationcode, leaguetype, leaguelength) VALUES('" + l.getLeagueName() + "','" + l.getInviteCode() + "','" + l.getLeagueType() + "','" + l.getLeagueLenght() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameLeague(String invitation_code){
        try {
            startConnection();
            try {
                rs = statement.executeQuery("Select * from league");
                while (rs.next()) {
                    if (invitation_code.equals(rs.getString("invitationcode")))
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

    public int numberOfLeaguePerUser(String new_username) {
        int c = 0;
        try {
            startConnection();
            try {
                for (int i = 1; i < 9; i++) {
                    rs = statement.executeQuery("Select * from league" +
                            "where name_user" + i + " = '" + new_username + "'");
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

    public List<League> LeaguesPerUser(String new_username){
        List<League> l = new LinkedList<>();
        try {
            startConnection();
            try {
                for (int i = 1; i < League.getMaxTeamsPerUser() + 1; i++) {
                    rs = statement.executeQuery("Select * from league" +
                            "where name_user" + i + " = '" + new_username + "'");
                    while(!rs.wasNull()) {
                        HashMap<User, Team> ut = new HashMap<>();
                        DataUser du = new DataUser();
                        DataTeam dt = new DataTeam();
                        for(int j = 0; j < League.getMaxUserPerLeague(); j++){
                            if(rs.getString("username" + j) != null && rs.getString("team_name" + j) != null)
                                ut.put(du.getUser(rs.getString("username" + j)), dt.getTeam(rs.getString("username" + j), rs.getString("name_team" + j)));
                        }
                        l.add(new League(rs.getString("leaguename"), rs.getString("invitationcode"), rs.getBoolean("leaguetype"), rs.getInt("leaguelength"), ut));
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
