package domain_classes;

import database.DataTeam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Team  {
    private static final int numDriver = 6;
    String teamName;
    double budget;
    int fantaf1points;
    public ArrayList<Abstract_f1_item> teamDrivers;
    static DataTeam dt = new DataTeam();
    String user;

    public Team() {
        this.budget = 100;
        teamDrivers = new ArrayList<>();
    }

    public Team(String teamName, String user) {
        this.teamName = teamName;
        this.user = user;
        this.budget = 100;
        this.teamDrivers = new ArrayList<>();
        dt.insertNewTeam(this.teamName, user);
    }

    public Team(String teamName, String user, ArrayList<Abstract_f1_item> teamDrivers) {
        this.teamName = teamName;
        this.teamDrivers = teamDrivers;
        this.budget = 100;
        this.user = user;
        dt.insertNewTeam(this, user);
    }

    public Team(String teamName, String user, ArrayList<Abstract_f1_item> teamDrivers, double budget, int fantaf1points) {
        this.teamName = teamName;
        this.budget = budget;
        this.fantaf1points = fantaf1points;
        this.teamDrivers = teamDrivers;
        this.user = user;
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

    public ArrayList<Abstract_f1_item> getTeamDrivers() {
        return teamDrivers;
    }

    public void insertAllItem(ArrayList<Abstract_f1_item> teamDrivers) {
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
        return Math.round(budget * 10.0) / 10.0;
    }

    public void deleteTeam() {
        dt.deleteTeam(this.teamName, this.user);
    }

    public boolean Updateitem(String name_item, int number_item, int position) {
        return dt.UpdateItem(this.user, this.teamName, name_item, number_item, position);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBudget(String d_name, int d_number){
        dt.setBudget(this.teamName, this.user, d_name, d_number);
    }

    public boolean check(Abstract_f1_item item){
        boolean b = false;
        if(teamDrivers.size() < numDriver){
            b = true;
            for (Abstract_f1_item i : teamDrivers) {
                if (item.getNumber() == i.getNumber())
                    b = false;
            }
        }
        return b;
    }

    //add an Item to the team
    public boolean addItem(Abstract_f1_item item) {
        //se non c'è gia nel team lo posso aggiungere
           // if(teamDrivers != null ){
                if(teamDrivers.size() < numDriver){
                    boolean b = true;
                    for (Abstract_f1_item i : teamDrivers) {
                        if (item.getNumber() == i.getNumber())
                            b = false;
                    }
                    if (b) {
                        teamDrivers.add(item);
                        dt.insertNewItem(this.user, this.teamName, item.getName(), item.getNumber());
                        return true;
                    }
                    return false;
              //  }
            }

            return false;


    }

    public void removeAll() {
        for (Abstract_f1_item i : teamDrivers) budget += i.fantavalue;
        teamDrivers.clear();

    }

    public void removeItem(Abstract_f1_item item) {
        teamDrivers.remove(item.number);
        budget += item.fantavalue;
        dt.deleteDriverFromTeam(item.getName(), item.getNumber(), this.teamName, this.user);
    }

    public boolean sameTeam() {
        return dt.sameTeam(this);
    }

    public static void deleteAllTeams() {
        dt.deleteAllTeams();
    }

    public Team getTeam() {
        return dt.getTeam(this.user, this.teamName);
    }

    public static Team getTeam(String teamname, String user) {
        return dt.getTeam(user, teamname);
    }

    @Override
    public String toString() {
        return "                " + fantaf1points + "                          " + teamName;
    }



}
