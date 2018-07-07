package net.java.main;

import net.java.main.core.Engine;
import net.java.main.dispachers.CommandDispatcher;
import net.java.main.io.OutputWriter;

public class Main {

    public static void main(String[] args) {
        OutputWriter writer = new OutputWriter();
        CommandDispatcher commandDispatcher = new CommandDispatcher();

        Engine gameEngine = new Engine(writer, commandDispatcher);
        gameEngine.start();
    }
}
