package domain_classes;

import java.util.Random;

public class Squad extends Abstract_f1_item{

    Driver d1, d2;
    Random r;

    public Squad(String name, Driver d1, Driver d2) {
        super(name);
        this.d1 = d1;
        this.d2 = d2;
        setNumber();
    }

    public Squad(String name, Integer number, Driver d1, Driver d2){
        super(name, number);
        this.d1 = d1;
        this.d2 = d2;
    }

    public void setNumber(){
        r = new Random();
        this.number = r.nextInt(100) + 100;
    }

    public Driver getD1() { return d1; }

    public void setD1(Driver d1) { this.d1 = d1; }

    public Driver getD2() { return d2; }

    public void setD2(Driver d2) { this.d2 = d2; }

    public boolean validSquad(){ return (!d1.SameDriver(d2)); }

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

}
