package database;

import domain_classes.League;

import java.sql.SQLException;

public class DataLeague extends Data {

    public void insertNewLeague(League l) {
        try {
            startConnection();
            statement.executeUpdate("INSERT INTO league VALUES('" + l.getLeagueName() + "','" + l.getInviteCode() + "','" + l.getLeagueType() + "','" + l.getLeagueLenght() + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "','" + null + "')");

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
}
