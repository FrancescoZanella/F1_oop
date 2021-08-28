package domain_classes;

public abstract class Abstract_f1_item implements F1_Item {
    String name;
    int number;
    int f1points;
    int fantaF1points;
    double fantavalue;

    public Abstract_f1_item(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Abstract_f1_item(String name) {
        this.name = name;
    }

    public Abstract_f1_item(String name, int number, int f1points, int fantaF1points, double fantavalue) {
        this.name = name;
        this.number = number;
        this.f1points = f1points;
        this.fantaF1points = fantaF1points;
        this.fantavalue = fantavalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getF1points() {
        return f1points;
    }

    public void setF1points(int f1points) {
        this.f1points = f1points;
    }

    public int getFantaF1points() {
        return fantaF1points;
    }

    public void setFantaF1points(int fantaF1points) {
        this.fantaF1points = fantaF1points;
    }

    public double getFantavalue() {
        return fantavalue;
    }

    public void setFantavalue(double fantavalue) {
        this.fantavalue = fantavalue;
    }
}