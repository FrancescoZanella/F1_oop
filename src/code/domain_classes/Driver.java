package domain_classes;

import database.Data;
import database.DataConstructor;
import database.DataDriver;

import java.lang.reflect.Constructor;

public class Driver extends Abstract_f1_item{

    int age;

    public Driver(String name, int age, int number){
        super(name, number);
        this.age = age;
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

    public boolean SameDriver(Driver d){
        return (number == d.number || name.equals(d.name));
    }

    @Override
    public void setFantavalue(double fantavalue) {
        super.setFantavalue(fantavalue);
        DataDriver dd = new DataDriver();
        dd.setFantaValue(name, number, fantavalue);
    }

    @Override
    public void setFantaF1points(int fantaF1points){
        super.setFantaF1points(fantaF1points);
        DataDriver dd = new DataDriver();
        dd.setFantaF1Points(name, number, fantaF1points);
        DataConstructor dc = new DataConstructor();
        dc.getConstructorbyDriver(name, number).setFantaF1points(fantaF1points);
    }

    @Override
    public void setF1points(int f1points) {
        super.setF1points(f1points);
        DataDriver dd = new DataDriver();
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
