package patterns.double_dispatch;

public abstract class Product {
    private double price;
    private String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public void addProperty(Sale sale) {
        sale.addProperty(SaleProperty.PRICE, price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
