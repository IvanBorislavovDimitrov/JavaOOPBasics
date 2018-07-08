package app.models.imp;

import app.models.api.Attackable;

public class DCHero extends Hero implements Attackable {

    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return this.getEnergy() / 1.5 + this.getSpecial() + this.getIntelligence();
    }

    @Override
    public String toString() {
        String str = super.toString()+ System.lineSeparator();
        str += String.format("####DC Attack Power: %.2f", this.attack());

        return str;
    }
}
