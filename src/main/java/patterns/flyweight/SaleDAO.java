package patterns.flyweight;

import patterns.double_dispatch.Sale;

public class SaleDAO {
    private final Sale sale;

    public SaleDAO(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }
}
