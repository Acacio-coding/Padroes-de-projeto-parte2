package patterns.facade;

public class PriceGetter {
    private Brand chevrolet;
    private Brand fiat;

    public PriceGetter() {
        this.chevrolet = new Chevrolet();
        this.fiat = new Fiat();
    }

    public void getChevroletPrices() {
        chevrolet.getPrices();
    }

    public void getFiatPrices() {
        fiat.getPrices();
    }
}
