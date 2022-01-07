package patterns.fluent_interfaces;

public class Employee {
    private int id;
    private String name;

    public Employee hasId(int id) {
        this.id = id;
        return this;
    }

    public Employee hasName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
