package domain_classes;

import java.util.HashMap;

public class Team {
    private static final int numDriver = 6;
    String TeamName;
    int budget = 250;
    public HashMap<Integer, Abstract_f1_item> TeamDrivers;

    public Team(String teamName, HashMap<Integer, Abstract_f1_item> teamDrivers) {
        TeamName = teamName;
        TeamDrivers = teamDrivers;
    }

    public static int getNumDriver() {
        return numDriver;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public HashMap<Integer, Abstract_f1_item> getTeamDrivers() {
        return TeamDrivers;
    }

    public void setTeamDrivers(HashMap<Integer, Abstract_f1_item> teamDrivers) {
        TeamDrivers = teamDrivers;
    }

    //add an Item to the team
    public void addItem(Integer number, Abstract_f1_item item){
        //se non c'è gia nel team lo posso aggiungere
        if(!TeamDrivers.containsKey(number)){
            TeamDrivers.put(number,item);
            budget-=item.fantavalue;
        }
    }

    public void removeAll(){
        for(Abstract_f1_item i : TeamDrivers.values()) budget += i.fantavalue;
        TeamDrivers.clear();

    }

    public void removeItem(Abstract_f1_item item){
        TeamDrivers.remove(item.number);
        budget-= item.fantavalue;
    }

    @Override
    public String toString() {
        return "Team{" +
                "TeamName='" + TeamName + '\'' +
                ", TeamDrivers=" + TeamDrivers +
                '}';
    }


}
