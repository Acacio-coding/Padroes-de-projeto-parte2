package patterns.decorator_and_proxy;

public interface CarDAOInterface {
    public void addCar(int id, String name, double price) throws CarException;

    public Car getCar(String name) throws CarException;
}
