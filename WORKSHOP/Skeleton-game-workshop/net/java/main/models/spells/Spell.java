package net.java.main.models.spells;

public class Spell {
    private int damage;
    private int energyCost;

    protected Spell(int damage, int energyCost) {
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }
}
