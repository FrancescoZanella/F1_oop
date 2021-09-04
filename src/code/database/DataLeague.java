package database;
import domain_classes.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class DataLeague extends Data {
    public ArrayList<Team> getallTeamsInTheLeague(String invitation_code) {
        try {
            startConnection();
            ArrayList<Team> t=new ArrayList<>();
            rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitation_code + "'");

                for(int i=1;i<9;i++){
                    t.add(League.getTeamInTheLeague(rs.getString("team_name" + i), invitation_code));
                }
                return t;




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    public void insertNewLeague(League l) {
        try {
            startConnection();
            int bool;
            if (l.getLeagueType())
                bool = 1;
            else
                bool = 0;
            statement.executeUpdate("INSERT INTO league (leaguename, invitationcode, leaguetype, leaguelength) VALUES('" + l.getLeagueName() + "','" + l.getInviteCode() + "','" + bool + "','" + l.getLeagueLenght() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public boolean sameLeague(String invitation_code) {
        try {
            startConnection();
            try {rs = statement.executeQuery("Select * from league WHERE invitationcode = '" + invitation_code + "'");
                if (rs.next())
                    return true;
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    public League getLeague(String invitation_code) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitation_code + "'");
            if (rs.next()) {
                HashMap<User, Team> dr = new HashMap<>();
                for (int i = 1; i < League.getMaxUserPerLeague(); i++)
                    dr.put(User.getUser(rs.getString("username" + i)), Team.getTeam(rs.getString("team_name" + i), rs.getString("username" + i)));
                return new League(rs.getString("leaguename"), rs.getString("invitationcode"), rs.getBoolean("leaguetype"), rs.getInt("leaguelength"), dr);
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    public Team getTeamInTheLeague(String user, String invitation_code) {
        try {
            startConnection();
            for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitation_code + "' and username" + i + " = '" + user + "'");
                if (rs.next()) {
                    return Team.getTeam(rs.getString("team_name" + i), user);
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    public int numberOfLeaguePerUser(String new_username) {
        int c = 0;
        try {
            startConnection();
            try {
                for (int i = 1; i < 9; i++) {
                    rs = statement.executeQuery("Select * from league " +
                            "where username" + i + " = '" + new_username + "'");
                    while (rs.next())
                        c++;
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
    public List<League> LeaguesPerUser(String new_username) {
        List<League> l = new LinkedList<>();
        try {
            startConnection();
            try {
                for (int i = 1; i < 9; i++) {
                    rs = statement.executeQuery("Select * from league " +
                            "where username" + i + " = '" + new_username + "'");
                    while (rs.next()) {
                        HashMap<User, Team> ut = new HashMap<>();
                        DataUser du = new DataUser();
                        DataTeam dt = new DataTeam();
                        for (int j = 1; j < League.getMaxUserPerLeague() + 1; j++) {
                            if (rs.getString("username" + j) != null && rs.getString("team_name" + j) != null)
                                ut.put(du.getUser(rs.getString("username" + j)), dt.getTeam(rs.getString("username" + j), rs.getString("team_name" + j)));
                        }
                        l.add(new League(rs.getString("leaguename"), rs.getString("invitationcode"), rs.getBoolean("leaguetype"), rs.getInt("leaguelength"), ut));
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
    public boolean insertNewUser(String new_username, String new_team, String invitationcode) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitationcode + "'");
            if (rs.next()) {
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("username" + i).equals(new_username))
                        return false;
                }
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("username" + i) == null && rs.getString("team_name" + i) == null) {
                        statement.executeUpdate("UPDATE league SET username" + i + "= '" + new_username + "', team_name" + i + "= '" + new_team + "'" +
                                " WHERE invitationcode = '" + invitationcode + "'");
                        return true;
                    }
                }
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean insertOnlyUser(String invitationcode, String new_username) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitationcode + "'");
            if (rs.next()) {
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("username" + i) != null) {
                        if (rs.getString("username" + i).equals(new_username))
                            return false;
                    }
                }
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("username" + i) == null) {
                        statement.executeUpdate("UPDATE league SET username" + i + " = '" + new_username + "'" +
                                " WHERE invitationcode = '" + invitationcode + "'");
                        return true;
                    }
                }
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean insertOnlyTeam(String invitationcode, String new_username, String new_team) {
        try {
            startConnection();
            rs = statement.executeQuery("SELECT * FROM league WHERE invitationcode = '" + invitationcode + "'");
            if (rs.next()) {
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("username" + i) != null) {
                        if (rs.getString("username" + i).equals(new_username) && rs.getString("team_name" + i) != null)
                            return false;
                    }
                }
                for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                    if (rs.getString("team_name" + i) == null && rs.getString("username" + i).equals(new_username)) {
                        statement.executeUpdate("UPDATE league SET team_name" + i + "= '" + new_team + "'" +
                                " WHERE invitationcode = '" + invitationcode + "'");
                        return true;
                    }
                }
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean deleteUserFromLeague(String new_username, String invitationcode) {
        try {
            startConnection();
            for (int i = 1; i < League.getMaxUserPerLeague() + 1; i++) {
                statement.executeUpdate("UPDATE league SET username" + i + "= null, team_name" + i + " = null" +
                        " WHERE invitationcode = '" + invitationcode + "' and username" + i + " = '" + new_username + "'");
                return true;
            }
            return false;
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    public void deleteAllLeagues() {
        try {
            startConnection();
            statement.executeUpdate("DELETE FROM league");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}