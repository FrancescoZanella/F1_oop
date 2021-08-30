package domain_classes;

import database.DataRace;

import java.text.DateFormat;
import java.sql.Date;

public class Race {

    final int NUMDRIVER = 20;
    final int NUMCONSTRUCTOR = 10;
    String name, nation;
    Date race_day, qualification_day;
    double km;
    static DataRace dr = new DataRace();
    boolean date;

    public Race(){

    }

    public Race(String name, String nation, double km) {
        this.name = name;
        this.nation = nation;
        this.km = km;
        dr.InsertNewRace(this);
    }

    public Race(String name, String nation, double km, Date race_day, Date qualification_day, boolean date) {
        this.name = name;
        this.nation = nation;
        this.race_day = race_day;
        this.km = km;
        this.qualification_day = qualification_day;
        if(date)
            dr.InsertNewRace(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Date getRace_day() { return race_day; }

    public void setRace_day(Date race_day) { this.race_day = race_day; }

    public Date getQualification_day() { return qualification_day; }

    public void setQualification_day(Date qualification_day) { this.qualification_day = qualification_day; }

    public boolean sameRace() {
        return dr.sameRace(this);
    }

    public static void deleteAllRaces() { dr.deleteAllRaces(); }

    public Race getRace() { return dr.getRace(this.name, this.nation, this.race_day); }

    public static Race getRace(String race_name, String race_nation, Date race_day) { return dr.getRace(race_name, race_nation, race_day); }

    public void deleteRace() { dr.deleteRace(this); }

    DateFormat datetoforma = DateFormat.getDateInstance(DateFormat.SHORT);

    public String toString() {
        return "Race{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", race_day=" + race_day +
                ", km=" + km +
                '}';
    }
}

