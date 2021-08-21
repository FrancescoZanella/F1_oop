package domain_classes;

public abstract class Abstract_f1_item implements F1_Item{
    String name;
    Integer number;
    int f1points;
    int fantaF1points;
    int fantavalue;

    public Abstract_f1_item(String name, Integer number) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public int getFantavalue() {
        return fantavalue;
    }

    public void setFantavalue(int fantavalue) {
        this.fantavalue = fantavalue;
    }
}