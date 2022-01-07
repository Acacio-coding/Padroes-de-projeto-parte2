package patterns.decorator_and_proxy;

import java.util.HashMap;
import java.util.Map;

public class CarDAOProxy implements CarDAOInterface {
    private Map<String, Car> cars;

    public CarDAOProxy() {
        this.cars = new HashMap<>();
    }

    @Override
    public void addCar(int id, String name, double price) {
        this.cars.put(name, new Car(id, name, price));
    }

    @Override
    public Car getCar(String name) {
        return cars.get(name);
    }
}
