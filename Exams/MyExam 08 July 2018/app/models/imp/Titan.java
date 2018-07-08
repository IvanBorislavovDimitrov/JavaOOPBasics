package app.models.imp;

import app.models.api.Attackable;

public class Titan extends AntiHero implements Attackable {

    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (this.getEnergy() + this.getIntelligence() + this.getSpecial()) * 3;
    }

    @Override
    public String toString() {
        String str = super.toString()+ System.lineSeparator();
        str += String.format("####Titan Attack Power: %.2f", this.attack());

        return str;
    }
}
