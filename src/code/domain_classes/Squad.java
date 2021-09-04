package domain_classes;

import database.DataConstructor;

import java.util.ArrayList;
import java.util.Random;

public class Squad extends Abstract_f1_item {

    Driver d1, d2;
    Random r;
    static DataConstructor dc = new DataConstructor();

    public Squad(){

    }

    public Squad(String name){
        super(name);
        setNumber();
        dc.InsertNewConstructor(this.name, this.number);
    }

    public Squad(String name,int fantavalue){
        super(name,fantavalue);
    }

    public Squad(String name, Driver d1, Driver d2) {
        super(name);
        this.d1 = d1;
        this.d2 = d2;
        setNumber();
        dc.InsertNewConstructor(this);
    }

    public Squad(String name, int number, Driver d1, Driver d2) {
        super(name, number);
        this.d1 = d1;
        this.d2 = d2;
        dc.InsertNewConstructor(this);
    }

    public Squad(String name, int number, Driver d1, Driver d2, int f1points, int fantaF1points, double fantavalue) {
        super(name, number, f1points, fantaF1points, fantavalue);
        this.d1 = d1;
        this.d2 = d2;
    }

    public void setNumber() {
        r = new Random();
        this.number = r.nextInt(100) + 100;
    }

    public Driver getD1() {
        return d1;
    }

    public void setD1(Driver d1) {
        this.d1 = d1;
    }

    public Driver getD2() {
        return d2;
    }

    public void setD2(Driver d2) {
        this.d2 = d2;
    }

    public boolean validSquad() {
        return (!d1.sameDriver(d2));
    }

    public boolean sameConstructor() {
        return dc.sameConstructor(this);
    }

    public void deleteConstructor() { dc.deleteConstructor(this); }

    public static void deleteAllConstructors() { dc.deleteAllConstructors(); }

    public Squad getConstructor() { return dc.getConstructor(this.name); }

    public static ArrayList<Squad> getAllConstructor(String order) { return dc.getAllConstructors(order); }

    public static Squad getConstructorByDriver(String driver_name, int driver_number) { return dc.getConstructorbyDriver(driver_name, driver_number); }

    public static Squad getConstructor(String constructor_name) { return dc.getConstructor(constructor_name); }

    public boolean insertNewDriver(String driver_name, int number_driver) { return dc.insertNewDriver(this.name, driver_name, number_driver); }

    public void setAllValues(int fantaf1points, int f1points, double fantavalue) {
        this.f1points += f1points;
        this.fantaF1points += fantaf1points;
        this.fantavalue = fantavalue;
        dc.setAllValues(this.name, this.number, fantaf1points, f1points, fantavalue);
    }

    @Override
    public void setFantavalue(double fantavalue) {
        super.setFantavalue(fantavalue);
        dc.setFantaValue(name, number, fantavalue);
    }

    @Override
    public void setFantaF1points(int fantaF1points) {
        super.setFantaF1points(fantaF1points);
        dc.setFantaF1Points(name, number, fantaF1points);
    }

    @Override
    public void setF1points(int f1points) {
        super.setF1points(f1points);
        dc.setF1Points(name, number, f1points);
    }

    public String F1informations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", f1points=" + f1points +
                '}';
    }

    public String allinformations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", f1points=" + f1points +
                ", fantaF1points=" + fantaF1points +
                ", fantavalue=" + fantavalue +
                '}';
    }

    public String fantainformations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", fantaF1points=" + fantaF1points +
                ", fantavalue=" + fantavalue +
                '}';
    }

    @Override
    public String toString() {
        return name + " " +
                fantavalue;
    }
}
