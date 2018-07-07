package net.java.main.handlers;

import net.java.main.interfaces.CombatHandler;
import net.java.main.models.units.Unit;

public abstract class CombatHandlerImpl implements CombatHandler{
    private Unit unit;

    protected CombatHandlerImpl() {
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    protected Unit getUnit() {
        return this.unit;
    }
}
