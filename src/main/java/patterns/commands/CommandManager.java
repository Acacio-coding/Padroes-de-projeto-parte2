package patterns.commands;

import patterns.flyweight.Database;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> done;
    private Stack<Command> undone;

    public CommandManager() {
        this.done = new Stack<>();
        this.undone = new Stack<>();
    }

    public void Do(Command command, Database db) {
        done.push(command);
        undone.clear();
        command.Do(db);
    }

    public void Undo(Database db) {
        if (!done.isEmpty()) {
            Command command = done.pop();
            undone.push(command);
            command.Undo(db);
        } else
            System.out.println("There's nothing to undo!");
    }
}
