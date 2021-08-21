package domain_classes;

public class Driver extends Abstract_f1_item{

    int number;
    int age;

    public Driver(String name, int age, Integer number){
        super(name, number);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public boolean SameDriver(Driver d){
        return (number == d.number || name.equals(d.name));
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
