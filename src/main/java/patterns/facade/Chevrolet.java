package patterns.facade;

import java.util.HashMap;
import java.util.Map;

public class Chevrolet implements Brand {
    private final Map<String, Double> table;

    public Chevrolet() {
        this.table = new HashMap<>();
        this.table.put("Onix 2014", 30.921);
        this.table.put("Prisma 2016", 32.123);
        this.table.put("Cruze 2018", 80.412);
    }

    @Override
    public void getPrices() {
        this.table.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }
}
