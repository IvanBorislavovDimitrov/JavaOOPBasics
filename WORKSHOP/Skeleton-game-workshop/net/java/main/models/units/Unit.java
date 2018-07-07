package net.java.main.models.units;

import net.java.main.interfaces.CombatHandler;

public class Unit {
    private String name;
    private Integer range;
    private int xPosition;
    private int yPosition;
    private int healthPoints;
    private int energyPoints;
    private int attackPoints;
    private int defencePoints;
    private CombatHandler combatHandler;

    protected Unit(
            String name,
            int range,
            int xPosition,
            int yPosition,
            int healthPoints,
            int energyPoints,
            int attackPoints,
            int defencePoints,
            CombatHandler combatHandler) {
        this.name = name;
        this.range = range;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.combatHandler = combatHandler;
        this.combatHandler.setUnit(this);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    
    public String getName() {
        return this.name;
    }

    public int getRange() {
        return this.range;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDefencePoints() {
        return this.defencePoints;
    }

    public CombatHandler getCombatHandler() {
        return this.combatHandler;
    }
}
