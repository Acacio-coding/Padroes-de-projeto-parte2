package patterns.decorator_and_proxy;

public class CarDAODecorator implements CarDAOInterface{
    private static CarDAOInterface carDao;

    public CarDAOInterface getCarDao() {
        if (carDao == null)
            carDao = new CarDAOProxy();
        return carDao;
    }

    @Override
    public void addCar(int id, String name, double price) throws CarException {
        if (id <= 0) throw new CarException("Car ID must be 1 or bigger!");
        else if (name.isBlank()) throw new CarException("Car name cannot be empty!");
        else if (price <= 0) throw new CarException("Car price must be 1 or bigger!");
        getCarDao().addCar(id, name, price);
    }

    @Override
    public Car getCar(String name) throws CarException {
        if (name.isBlank()) throw new CarException("Car name cannot be empty!");
        Car car = getCarDao().getCar(name);
        if (car == null) throw new CarException("Car does not exist in database!");
        return car;
    }
}
