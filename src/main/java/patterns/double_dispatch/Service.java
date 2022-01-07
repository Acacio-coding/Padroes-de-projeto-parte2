package patterns.double_dispatch;

public class Service extends Product {
    private int id;

    public Service(double price, int id, String name) {
        super(price, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
