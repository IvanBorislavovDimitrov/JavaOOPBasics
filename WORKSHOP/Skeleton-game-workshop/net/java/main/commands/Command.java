package net.java.main.commands;

import net.java.main.exceptions.GameException;

public class Command {
    public String execute(String[] args) {
        throw new GameException("Invalid command");
    }
}
