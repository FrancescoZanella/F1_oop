package domain_classes;
import database.DataUser;
import java.sql.SQLException;
import java.util.LinkedHashSet;
public class User {
    String name, surname, mail;
    String username;
    String password;
    LinkedHashSet<Team> all_teams;
    static DataUser du = new DataUser();
    public User(String username) {
        this.username = username;
    }

    public User(String name, String surname, String mail, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.username = username;
        this.password = password;
        du.InsertNewUser(this);
    }


    public User(String name, String surname, String mail, String username) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.username = username;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        du.InsertNewUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
        du.setPassword(this.username, password);
    }

    public String getPassword() {
        return this.password;
    }

    public String getDbPassword() {
        return du.getPassword(this.username);
    }

    public LinkedHashSet<Team> getAll_teams() {
        return all_teams;
    }

    public void setAll_teams(LinkedHashSet<Team> all_teams) {
        this.all_teams = all_teams;
    }

    public void clearAllTeams(LinkedHashSet<Team> all_teams) {
        all_teams.clear();
    }

    public LinkedHashSet<Team> newAll_teams() {
        return new LinkedHashSet<>();
    }

    public boolean sameUser() {
        return du.sameUser(this.username);
    }

    public static boolean sameUser(String username) {
        return du.sameUser(username);
    }

    public boolean correctLogin(){ return du.sameUser(this.username); }

    public User getUser() { return du.getUser(this.username); }

    public static User getUser(String username) { return du.getUser(username); }

    public static void deleteAllUsers() { du.deleteAllUsers(); }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}