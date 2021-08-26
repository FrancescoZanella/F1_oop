package domain_classes;

public class League {
    String LeagueName;
    String InviteCode;
    private static final int MaxUserPerLeague = 8;
    //Private only member with an invite can join--->false
    //Public all the world can join the league--->true
    Boolean LeagueType;
    private static final int MaxTeamsPerUser = 1;
    //1-25 race's number
    Integer LeagueLenght;

    public League(String leagueName, String inviteCode, Boolean leagueType, Integer leagueLenght) {
        LeagueName = leagueName;
        InviteCode = inviteCode;
        LeagueType = leagueType;
        LeagueLenght = leagueLenght;
    }

    public String getLeagueName() {

        return LeagueName;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public String getInviteCode() {
        return InviteCode;
    }

    public void setInviteCode(String inviteCode) {
        InviteCode = inviteCode;
    }

    public static int getMaxUserPerLeague() {
        return MaxUserPerLeague;
    }

    public Boolean getLeagueType() {
        return LeagueType;
    }

    public void setLeagueType(Boolean leagueType) {
        LeagueType = leagueType;
    }

    public static int getMaxTeamsPerUser() {
        return MaxTeamsPerUser;
    }

    public Integer getLeagueLenght() {
        return LeagueLenght;
    }

    public void setLeagueLenght(Integer leagueLenght) {
        LeagueLenght = leagueLenght;
    }


}
