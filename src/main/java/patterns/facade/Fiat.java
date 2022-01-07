package patterns.facade;

import java.util.HashMap;
import java.util.Map;

public class Fiat implements Brand {
    private final Map<String, Double> table;

    public Fiat() {
        this.table = new HashMap<>();
        this.table.put("Argo 2014", 30.311);
        this.table.put("Grand Siena 2016", 32.451);
        this.table.put("Cronos 2018", 65.745);
    }

    @Override
    public void getPrices() {
        this.table.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }
}
