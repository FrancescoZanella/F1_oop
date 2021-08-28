package domain_classes;

import java.util.HashMap;

public class Team {
    private static final int numDriver = 6;
    String teamName;
    double budget;
    int fantaf1points;
    public HashMap<Integer, Abstract_f1_item> teamDrivers;

    public Team(String teamName){
        this.teamName = teamName;
        this.teamDrivers = new HashMap<>();
    }

    public Team(String teamName, HashMap<Integer, Abstract_f1_item> teamDrivers) {
        this.teamName = teamName;
        this.teamDrivers = teamDrivers;
        this.budget = 250;
    }

    public Team(String teamName, HashMap<Integer, Abstract_f1_item> teamDrivers, double budget, int fantaf1points) {
        this.teamName = teamName;
        this.budget = budget;
        this.fantaf1points = fantaf1points;
        this.teamDrivers = teamDrivers;
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

    public void setTeamDrivers(HashMap<Integer, Abstract_f1_item> teamDrivers) {
        this.teamDrivers = teamDrivers;
    }

    public int getFantaf1points() {
        return fantaf1points;
    }

    public void setFantaf1points(int fantaf1points) {
        this.fantaf1points = fantaf1points;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
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
    }

    @Override
    public String toString() {
        return "Team{" +
                "TeamName='" + teamName + '\'' +
                ", TeamDrivers=" + teamDrivers +
                '}';
    }


}
