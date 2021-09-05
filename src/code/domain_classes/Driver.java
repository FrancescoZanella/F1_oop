package domain_classes;

import database.DataConstructor;
import database.DataDriver;

import java.util.ArrayList;


public class Driver extends Abstract_f1_item {


    int age;
    static DataDriver dd = new DataDriver();
    String race_position = "0";
    String qualifying_position = "0";

    public Driver() {

    }

    public Driver(String name, int number) {
        super(name, number);
    }

    public Driver(String name, int age, int number) {
        super(name, number);
        this.age = age;
        dd.InsertNewDriver(this);
    }

    public Driver(String name, int age, int number, int f1points, int fantaF1points, double fantavalue, String race_position, String qualifying_position) {
        super(name, number, f1points, fantaF1points, fantavalue);
        this.age = age;
        this.race_position = race_position;
        this.qualifying_position = qualifying_position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace_position() {
        return race_position;
    }

    public void setRace_position(String race_position) {
        this.race_position = race_position;
        dd.setRacePosition(this.name, this.number, race_position);
    }

    public static ArrayList<Driver> getAllDrivers(String order) { return dd.getAllDrivers(order); }

    public String getQualifying_position() {
        return dd.getDriver(this.name, this.number).qualifying_position;
    }

    public void setQualifying_position(String qualifying_position) {
        this.qualifying_position = qualifying_position;
        dd.setQualifyingPosition(this.name, this.number, qualifying_position);
    }

    public boolean sameDriver(Driver d) {
        return (d.getName().equals(this.name) && d.getNumber() == this.number);
    }

    public boolean SameDriver() {
        return dd.sameDriver(this);
    }

    public void deleteDriver() {
        dd.deleteDriver(this);
    }

    public static void deleteAllDrivers() {
        dd.deleteAllDrivers();
    }

    public Driver getDriver() {
        return dd.getDriver(this.name, this.number);
    }

    public static Driver getDriver(String username, int number) {
        return dd.getDriver(username, number);
    }

    public void setAllValues(int f1points, int fantaf1points, double fantavalue) {
        this.f1points += f1points;
        this.fantaF1points += fantaf1points;
        this.fantavalue = fantavalue;
        dd.setAllValues(this.name, this.number, fantaf1points, f1points, fantavalue);
    }

    @Override
    public void setFantavalue(double fantavalue) {
        super.setFantavalue(fantavalue);
        dd.setFantaValue(name, number, fantavalue);
    }

    public void setFantaF1points(int fantaF1points, boolean even_constructor) {
        super.setFantaF1points(fantaF1points);
        dd.setFantaF1Points(name, number, fantaF1points);
        if (even_constructor) {
            Squad.getConstructorByDriver(name, number).setFantaF1points(fantaF1points);
        }
    }

    @Override
    public void setF1points(int f1points) {
        super.setF1points(f1points);
        dd.setF1Points(name, number, f1points);
    }

    @Override
    public double getFantavalue(){
        this.fantavalue = dd.getDriver(this.name, this.number).fantavalue;
        return super.getFantavalue();
    }

    public String F1informations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", f1points=" + f1points +
                '}';
    }

    public String allinformations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", f1points=" + f1points +
                ", fantaF1points=" + fantaF1points +
                ", fantavalue=" + fantavalue +
                '}';
    }

    @Override
    public String toString() {
        return name + " " + Math.round(fantavalue * 10.0) / 10.0;
    }

    public String fantainformations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", fantaF1points=" + fantaF1points +
                ", fantavalue=" + fantavalue +
                '}';
    }
}
