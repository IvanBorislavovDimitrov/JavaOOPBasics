package net.java.main.dispachers;

import net.java.main.commands.Command;
import net.java.main.commands.GameOverCommand;
import net.java.main.exceptions.GameException;

public class CommandDispatcher {
    public String dispatchCommand(String[] args) throws GameException {
        switch (args[0]) {
            case "game-over":
                return new GameOverCommand().execute(args);
            default:
                return new Command().execute(args);
        }
    }
}
