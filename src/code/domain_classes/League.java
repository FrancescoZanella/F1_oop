package domain_classes;
import database.DataLeague;
import java.util.HashMap;
import java.util.List;
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
    static DataLeague dl = new DataLeague();
    public League() {
    }
    //da usare la prima volta che si crea una lega, così ti genera il codice di invito
    public League(String leagueName, String inviteCode, boolean leagueType, int leagueLenght) {
        this.leagueName = leagueName;
        this.leagueType = leagueType;
        this.leagueLenght = leagueLenght;
        this.inviteCode = inviteCode;
        this.userteam = new HashMap<>();
        dl.insertNewLeague(this);
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
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
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
    public Team getTeamInTheLeague(String user) {
        return dl.getTeamInTheLeague(user, this.inviteCode);
    }
    public static Team getTeamInTheLeague(String user, String invitation_code) {
        return dl.getTeamInTheLeague(user, invitation_code);
    }

    public boolean sameLeague() {
        return dl.sameLeague(inviteCode);
    }
    public static boolean sameLeague(String inviteCode) {
        return dl.sameLeague(inviteCode);
    }
    public static int numberofLeaguesPerUser(String username) {
        return dl.numberOfLeaguePerUser(username);
    }
    public static List<League> leaguesPerUser(String username) {
        return dl.LeaguesPerUser(username);
    }
    public static void deleteAllLeagues() {
        dl.deleteAllLeagues();
    }
    public League getLeague() {
        return dl.getLeague(this.inviteCode);
    }
    public static League getLeague(String invitation_code) {
        return dl.getLeague(invitation_code);
    }

    public boolean insertOnlyTeam(String new_username, String new_team) {
        if (dl.insertOnlyTeam(this.inviteCode, new_username, new_team)) {
            userteam.remove(User.getUser(new_username));
            userteam.put(User.getUser(new_username), Team.getTeam(new_team, new_username));
            return true;
        }
        return false;
    }

    public boolean insertOnlyUser(String new_username) {
        if (dl.insertOnlyUser(this.inviteCode, new_username)) {
            userteam.put(User.getUser(new_username), null);
            return true;
        }
        return false;
    }

    public static boolean insertOnlyUser(String inviteCode, String new_username) {
        return dl.insertOnlyUser(inviteCode, new_username);
    }

    public boolean addNewTeam(User u, Team t) {
        if (userteam.size() < MaxTeamsPerUser) {
            if (userteam.get(u) != null)
                return false;
            else {
                dl.insertNewUser(u.getUsername(), t.getTeamName(), inviteCode);
                userteam.put(u, t);
                return true;
            }
        }
        return false;
    }


        public boolean deleteUserFromLeague(User u) {
            userteam.remove(u);
            return dl.deleteUserFromLeague(u.getUsername(), this.inviteCode);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        @Override
        public String toString() {
            return "League{" +
                    "leagueName='" + leagueName + '\'' +
                    ", inviteCode='" + inviteCode + '\'' +
                    ", leagueType=" + leagueType +
                    ", userteam=" + userteam +
                    ", leagueLenght=" + leagueLenght +
                    '}';
        }
    }