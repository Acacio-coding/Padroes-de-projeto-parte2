package patterns.decorator_and_proxy;

import patterns.double_dispatch.Product;

public class Car extends Product {
    private int id;

    public Car(int id, String name, double price) {
        super(price, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
