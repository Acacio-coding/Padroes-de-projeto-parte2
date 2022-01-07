package main;

import patterns.commands.CommandManager;
import patterns.commands.RemoveSale;
import patterns.commands.SaveSale;
import patterns.decorator_and_proxy.Car;
import patterns.decorator_and_proxy.CarDAODecorator;
import patterns.decorator_and_proxy.CarDAOInterface;
import patterns.decorator_and_proxy.CarException;
import patterns.double_dispatch.Product;
import patterns.double_dispatch.Sale;
import patterns.double_dispatch.Service;
import patterns.facade.PriceGetter;
import patterns.fluent_interfaces.Employee;
import patterns.flyweight.ConnectionFactory;
import patterns.flyweight.DBException;
import patterns.flyweight.Database;
import patterns.flyweight.SaleDAO;
import patterns.static_factory_and_singleton.MonthEmployee;
import patterns.static_factory_and_singleton.MonthEmployeeException;

public class Main {
    public static void main(String[] args) throws MonthEmployeeException, DBException {
        //Proxy e Decorator
        CarDAOInterface carDao = new CarDAODecorator();

        try {
            carDao.addCar(0, "Carro1", 2500.00);
            carDao.addCar(1, "", 2500.00);
            carDao.addCar(1, " ", 2500.00);
            carDao.addCar(1, "Carro1", 0);
        } catch (CarException exception) {
            System.out.println("Error during operation:");
            System.out.println(exception.getMessage());
        }

        try {
            carDao.addCar(1, "Carro1", 2500.00);
        } catch (CarException exception) {
            System.out.println("\nError during operation:");
            System.out.println(exception.getMessage());
        }

        try {
            Car car = carDao.getCar("Carro2");
            System.out.println("\nCar data:");
            System.out.println("ID: " + car.getId());
            System.out.println("Name: " + car.getName());
            System.out.println("Price: " + car.getPrice());
        } catch (CarException exception) {
            System.out.println("\nError during operation:");
            System.out.println(exception.getMessage());
        }

        try {
            Car car = carDao.getCar("Carro1");
            System.out.println("\n-------------------------------------");
            System.out.println("Car data:");
            System.out.println("-------------------------------------");
            System.out.println("ID: " + car.getId());
            System.out.println("Name: " + car.getName());
            System.out.println("Price: " + car.getPrice());
            System.out.println("-------------------------------------");
        } catch (CarException exception) {
            System.out.println("\nError during operation:");
            System.out.println(exception.getMessage());
        }


        //Fluent interfaces
        Employee employee = new Employee().hasId(0).hasName("Acacio");

        //Static Factory and Singleton
        MonthEmployee monthEmployee = MonthEmployee.create(employee, "I wanted it to be", "January");
        MonthEmployee monthEmployee1 = MonthEmployee.createNoCurrentMonth(employee, "I wanted it to be");

        System.out.println("\n-------------------------------------");
        System.out.println("Month Employee");
        System.out.println("-------------------------------------");
        System.out.println("ID: " + monthEmployee.getEmployee().getId());
        System.out.println("Name: " + monthEmployee.getEmployee().getName());
        System.out.println("Reason: " + monthEmployee.getReason());
        System.out.println("Current month: " + monthEmployee.getCurrentMonth());
        System.out.println("-------------------------------------");

        System.out.println("\n-------------------------------------");
        System.out.println("Month Employee");
        System.out.println("-------------------------------------");
        System.out.println("ID: " + monthEmployee1.getEmployee().getId());
        System.out.println("Name: " + monthEmployee1.getEmployee().getName());
        System.out.println("Reason: " + monthEmployee1.getReason());
        System.out.println("Current month: " + monthEmployee1.getCurrentMonth());
        System.out.println("-------------------------------------");

        //Double dispatch
        Sale sale = new Sale(0);

        try {
            Car car = carDao.getCar("Carro1");
            Service service = new Service(150, 0, "Update GPS");
            sale.addProduct(car);
            sale.addProduct(service);
        } catch (CarException exception) {
            System.out.println("\nError during operation:");
            System.out.println(exception.getMessage());
        }

        System.out.println("\n-------------------------------------");
        System.out.println("Summary");
        System.out.println("-------------------------------------");
        for (Product product : sale.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("-------------------------------------");
        System.out.println("Total: " + sale.getTotal());
        System.out.println("-------------------------------------");


        //Flyweight and Commands
        Database db = new Database();
        CommandManager commandManager = new CommandManager();

        System.out.println("\n-------------------------------------");
        if (ConnectionFactory.getConnection()) {
            commandManager.Do(new SaveSale(new SaleDAO(sale)), db);
            System.out.println("-------------------------------------");
        } else {
            throw new DBException("Database connection error!");
        }

        if (ConnectionFactory.getConnection()) {
            db.get(new SaleDAO(sale));
            System.out.println("-------------------------------------");
        } else {
            throw new DBException("Database connection error!");
        }

        if (ConnectionFactory.getConnection()) {
            commandManager.Do(new RemoveSale(new SaleDAO(sale)), db);
            System.out.println("-------------------------------------");
            commandManager.Undo(db);
            System.out.println("-------------------------------------");
            commandManager.Do(new RemoveSale(new SaleDAO(sale)), db);
            System.out.println("-------------------------------------");
        } else {
            throw new DBException("Database connection error!");
        }

        //Facade
        PriceGetter pg = new PriceGetter();
        System.out.println("\n-------------------------------------");
        System.out.println("Price table");
        System.out.println("-------------------------------------");
        System.out.println("Chevrolet");
        System.out.println("-------------------------------------");
        pg.getChevroletPrices();
        System.out.println("-------------------------------------");
        System.out.println("Fiat");
        System.out.println("-------------------------------------");
        pg.getFiatPrices();
        System.out.println("-------------------------------------");
    }
}
