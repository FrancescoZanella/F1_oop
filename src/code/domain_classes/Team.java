package domain_classes;

import database.DataTeam;

import java.util.HashMap;

public class Team {
    private static final int numDriver = 6;
    String teamName;
    double budget;
    int fantaf1points;
    public HashMap<Integer, Abstract_f1_item> teamDrivers;
    DataTeam dt;
    String user;

    public Team(String teamName, String user) {
        this.teamName = teamName;
        this.user = user;
        this.teamDrivers = new HashMap<>();
        dt = new DataTeam();
        dt.insertNewTeam(this.teamName, user);
    }

    public Team(String teamName, String user, HashMap<Integer, Abstract_f1_item> teamDrivers) {
        this.teamName = teamName;
        this.teamDrivers = teamDrivers;
        this.budget = 250;
        this.user = user;
        dt = new DataTeam();
        dt.insertNewTeam(this, user);
    }

    public Team(String teamName, String user, HashMap<Integer, Abstract_f1_item> teamDrivers, double budget, int fantaf1points) {
        this.teamName = teamName;
        this.budget = budget;
        this.fantaf1points = fantaf1points;
        this.teamDrivers = teamDrivers;
        this.user = user;
        dt = new DataTeam();
    }

    public static int getNumDriver() {
        return numDriver;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public HashMap<Integer, Abstract_f1_item> getTeamDrivers() {
        return teamDrivers;
    }

    public void insertAllItem(HashMap<Integer, Abstract_f1_item> teamDrivers) {
        this.teamDrivers = teamDrivers;
        dt.insertAllItem(this.user, this.teamName, teamDrivers);
    }

    public int getFantaf1points() {
        return fantaf1points;
    }


    public String getUser() {
        return user;
    }

    public double getBudget() {
        return budget;
    }

    public void deleteTeam() {
        dt.deleteTeam(this.teamName, this.user);
    }

    //add an Item to the team
    public void addItem(Abstract_f1_item item) {
        //se non c'è gia nel team lo posso aggiungere
        if (teamDrivers.size() < numDriver) {
            boolean b = true;
            for (Abstract_f1_item i : teamDrivers.values()) {
                if (item.getNumber() == i.getNumber())
                    b = false;
            }
            if (b) {
                teamDrivers.put(item.getNumber(), item);
                budget -= item.fantavalue;
                dt.insertNewItem(this.user, this.teamName, item.getName(), item.getNumber());
            }
        }
    }

    public void removeAll() {
        for (Abstract_f1_item i : teamDrivers.values()) budget += i.fantavalue;
        teamDrivers.clear();

    }

    public void removeItem(Abstract_f1_item item) {
        teamDrivers.remove(item.number);
        budget += item.fantavalue;
        dt.deleteDriverFromTeam(item.getName(), item.getNumber(), this.teamName, this.user);
    }

    @Override
    public String toString() {
        return "Team{" +
                "TeamName='" + teamName + '\'' +
                ", TeamDrivers=" + teamDrivers +
                '}';
    }


}
