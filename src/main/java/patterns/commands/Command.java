package patterns.commands;

import patterns.flyweight.Database;

public interface Command {
    public boolean Do(Database db);

    public boolean Undo(Database db);
}
