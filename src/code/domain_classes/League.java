package domain_classes;

import java.util.HashMap;
import java.util.Random;

public class League {
    String leagueName;
    String inviteCode;
    private static final int MaxUserPerLeague = 8;
    //Private only member with an invite can join--->false
    //Public all the world can join the league--->true
    boolean leagueType;
    private static final int MaxTeamsPerUser = 1;
    HashMap<User, Team> userteam;
    //1-25 race's number
    int leagueLenght;

    //da usare la prima volta che si crea una lega, così ti genera il codice di invito
    public League(String leagueName, String inviteCode, boolean leagueType, int leagueLenght) {
        this.leagueName = leagueName;
        this.leagueType = leagueType;
        this.leagueLenght = leagueLenght;
        this.inviteCode = inviteCode;
        this.userteam = new HashMap<>();
    }


    //da usare quando la lega è già creata e se ne vuole una copia
    public League(String leaguename, String inviteCode, boolean leagueType, int leagueLenght, HashMap<User, Team> userteam) {
        this.leagueName = leaguename;
        this.inviteCode = inviteCode;
        this.leagueType = leagueType;
        this.leagueLenght = leagueLenght;
        this.userteam = userteam;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setInviteCode(String inviteCode) { this.inviteCode = inviteCode; }

    public String getInviteCode() {
        return inviteCode;
    }

    public static int getMaxUserPerLeague() {
        return MaxUserPerLeague;
    }

    public boolean getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(boolean leagueType) {
        this.leagueType = leagueType;
    }

    public static int getMaxTeamsPerUser() {
        return MaxTeamsPerUser;
    }

    public int getLeagueLenght() {
        return leagueLenght;
    }

    public void setLeagueLenght(int leagueLenght) {
        this.leagueLenght = leagueLenght;
    }

    public HashMap<User, Team> getUserteam() {
        return userteam;
    }

    public void setUserteam(HashMap<User, Team> userteam) {
        this.userteam = userteam;
    }

    public boolean addNewTeam(User u, Team t) {
        if (userteam.size() < MaxTeamsPerUser) {
            if (userteam.get(u) != null)
                return false;
            else {
                userteam.put(u, t);
                return true;
            }
        }
        return false;
    }


}
