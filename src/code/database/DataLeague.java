package database;

import domain_classes.League;

import java.sql.SQLException;

public class DataLeague extends Data {

    public void insertNewLeague(League l) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO league VALUES('" + l.getLeagueName() + "','" + l.getInviteCode() + "','" + l.getLeagueType() + "','" + l.getLeagueLenght() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public boolean sameLeague(League l){
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
}
