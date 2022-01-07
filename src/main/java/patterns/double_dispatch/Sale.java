package patterns.double_dispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sale {
    private int id;
    private ArrayList<Product> products;
    private Map<SaleProperty, Double> properties;

    public Sale(int id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.properties = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        product.addProperty(this);
    }

    public void addProperty(SaleProperty property, double value) {
        if (!getProperties().containsKey(property)) getProperties().put(property, 0.0);
        getProperties().put(property, getProperties().get(property) + value);
    }

    public double getTotal() {
        if (products.isEmpty()) return 0;

        double total = 0;

        if (getProperties().containsKey(SaleProperty.PRICE))
            total += getProperties().get(SaleProperty.PRICE);

        return total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Map<SaleProperty, Double> getProperties() {
        return properties;
    }

    public int getId() {
        return id;
    }
}
