package domain_classes;

import database.DataConstructor;
import database.DataDriver;


public class Driver extends Abstract_f1_item {

    int age;
    static DataDriver dd = new DataDriver();

    public Driver(){

    }

    public Driver(String name, int age, int number) {
        super(name, number);
        this.age = age;
        dd.InsertNewDriver(this);
    }

    public Driver(String name, int age, int number, int f1points, int fantaF1points, double fantavalue) {
        super(name, number, f1points, fantaF1points, fantavalue);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean sameDriver(Driver d) {
        return (d.getName().equals(this.name) && d.getNumber() == this.number);
    }

    public boolean SameDriver() {
        return dd.sameDriver(this);
    }

    public void deleteDriver() { dd.deleteDriver(this); }

    public static void deleteAllDrivers() { dd.deleteAllDrivers(); }

    public Driver getDriver() { return dd.getDriver(this.name, this.number); }

    public static Driver getDriver(String username, int number) { return dd.getDriver(username, number); }

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

    @Override
    public void setFantaF1points(int fantaF1points) {
        super.setFantaF1points(fantaF1points);
        dd.setFantaF1Points(name, number, fantaF1points);
        DataConstructor dc = new DataConstructor();
        dc.getConstructorbyDriver(name, number).setFantaF1points(fantaF1points);
    }

    @Override
    public void setF1points(int f1points) {
        super.setF1points(f1points);
        dd.setF1Points(name, number, f1points);
        DataConstructor dc = new DataConstructor();
        dc.getConstructorbyDriver(name, number).setF1points(f1points);
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

    public String fantainformations() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", fantaF1points=" + fantaF1points +
                ", fantavalue=" + fantavalue +
                '}';
    }
}
