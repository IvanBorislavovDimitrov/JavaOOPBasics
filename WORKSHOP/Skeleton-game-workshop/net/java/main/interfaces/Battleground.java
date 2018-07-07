package net.java.main.interfaces;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.models.units.Unit;

import java.util.List;

public interface Battleground {

    List<Unit> getUnitsInRange(int xPosition, int yPosition, int range);

    void add(Unit unit) throws InvalidPositionException;

    void remove(Unit unit) throws InvalidPositionException;

    void move(Unit unit, int xPosition, int yPosition) throws InvalidPositionException;
}
