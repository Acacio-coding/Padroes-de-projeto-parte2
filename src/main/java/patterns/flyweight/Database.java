package patterns.flyweight;

import patterns.double_dispatch.Product;

import java.util.ArrayList;

public class Database {
    private final ArrayList<SaleDAO> sales;

    public Database() {
        this.sales = new ArrayList<>();
    }

    public void save(SaleDAO sale) throws DBException {
        if (this.sales.add(sale))
            System.out.println("Sale saved successfully!");
        else
            throw new DBException("Error during save operation!");
    }

    public void remove(SaleDAO sale) throws DBException {
        if (sales.removeIf(s -> s.getSale().getId() == sale.getSale().getId()))
            System.out.println("Sale removed successfully!");
        else
            throw new DBException("Sale not found on database!");
    }

    public void get(SaleDAO sale) throws DBException {
        boolean found = false;
        for (SaleDAO s : sales) {
            if (s.getSale().getId() == sale.getSale().getId()) {
                found = true;
                System.out.println("Sale found");
                System.out.println("-------------------------------------");
                for (Product p : s.getSale().getProducts()) {
                    System.out.println(p.getName() + " - " + p.getPrice());
                }
                System.out.println("-------------------------------------");
                System.out.println("Total: " + s.getSale().getTotal());
            }
        }

        if (!found)
            throw new DBException("Sale not found on database!");
    }

    public ArrayList<SaleDAO> getSales() {
        return sales;
    }
}
