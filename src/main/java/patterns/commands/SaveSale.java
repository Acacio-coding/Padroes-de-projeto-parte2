package patterns.commands;

import patterns.flyweight.DBException;
import patterns.flyweight.Database;
import patterns.flyweight.SaleDAO;

public class SaveSale implements Command {
    private final SaleDAO saleDao;

    public SaveSale(SaleDAO saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public boolean Do(Database db) {
        try {
            db.save(saleDao);
            return true;
        } catch (DBException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean Undo(Database db) {
        try {
            db.remove(saleDao);
            return true;
        } catch (DBException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

}
