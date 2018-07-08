package app.models.imp;

import app.models.api.Attackable;

public class Villain extends AntiHero implements Attackable {

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (this.getIntelligence() * this.getSpecial()) / this.getEnergy();
    }

    @Override
    public String toString() {
        String str = super.toString()  + System.lineSeparator();
        str += String.format("####Villain Attack Power: %.2f", this.attack());

        return str;
    }
}
