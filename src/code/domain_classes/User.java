package domain_classes;

import java.util.LinkedHashSet;

public class User {
    String name, surname, mail;
    String username;
    char[] password;
    LinkedHashSet<Team> all_teams;

    public User(String name, String surname, String mail, String username, char[] password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(char[] password) { this.password = password; }

    public char[] getPassword() { return password; }

    public LinkedHashSet<Team> getAll_teams() { return all_teams; }

    public void setAll_teams(LinkedHashSet<Team> all_teams) { this.all_teams = all_teams; }

    public void clearAllTeams(LinkedHashSet<Team> all_teams) { all_teams.clear(); }

    public LinkedHashSet<Team> newAll_teams() { return new LinkedHashSet<>(); }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
