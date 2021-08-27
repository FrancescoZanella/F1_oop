package domain_classes;

import java.text.DateFormat;
import java.sql.Date;

public class Race {

    final int NUMDRIVER = 20;
    final int NUMCONSTRUCTOR = 10;
    String name, nation;
    Date race_day, qualification_day;
    float km;

    public Race(String name, String nation, float km) {
        this.name = name;
        this.nation = nation;
        this.km = km;
    }

    public Race(String name, String nation, Date race_day, float km, Date qualification_day) {
        this.name = name;
        this.nation = nation;
        this.race_day = race_day;
        this.km = km;
        this.qualification_day = qualification_day;
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

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public Date getRace_day() { return race_day; }

    public void setRace_day(Date race_day) { this.race_day = race_day; }

    public Date getQualification_day() { return qualification_day; }

    public void setQualification_day(Date qualification_day) { this.qualification_day = qualification_day; }

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

