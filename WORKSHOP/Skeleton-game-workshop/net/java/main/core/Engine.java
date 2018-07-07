package net.java.main.core;

import net.java.main.dispachers.CommandDispatcher;
import net.java.main.exceptions.GameException;
import net.java.main.io.OutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private BufferedReader bufferedReader;
    private OutputWriter outputWriter;
    private CommandDispatcher commandDispatcher;

    public Engine(
            OutputWriter outputWriter,
            CommandDispatcher commandDispatcher) {
        this.outputWriter = outputWriter;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.commandDispatcher = commandDispatcher;
    }

    public void start() {

        while (true) {
            try {
                String userInput = this.bufferedReader.readLine();
                String[] args = userInput.split("\\s+");

                String result = this.commandDispatcher.dispatchCommand(args);

                this.outputWriter.writeLine(result);

                if (result.equals("Game over!")) {
                    break;
                }
            } catch (GameException | IOException e) {
                this.outputWriter.writeLine(e.getMessage());
            }
        }
    }
}
