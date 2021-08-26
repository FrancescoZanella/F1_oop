package domain_classes;

import java.util.Random;

public class League {
    String leagueName;
    int inviteCode;
    private static final int MaxUserPerLeague = 8;
    //Private only member with an invite can join--->false
    //Public all the world can join the league--->true
    boolean leagueType;
    private static final int MaxTeamsPerUser = 1;
    //1-25 race's number
    int leagueLenght;
    Random r;

    public League(String leagueName, boolean leagueType, int leagueLenght) {
        this.leagueName = leagueName;
        this.leagueType = leagueType;
        this.leagueLenght = leagueLenght;
        r = new Random();
        this.inviteCode = r.nextInt(10000) + 10000;
    }

    public String getLeagueName() { return leagueName; }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setInviteCode() {
        r = new Random();
        this.inviteCode = r.nextInt(10000) + 10000;
    }

    public int getInviteCode() { return inviteCode; }

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


}
