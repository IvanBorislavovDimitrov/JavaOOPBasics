package app.models.imp;

import app.models.api.Attackable;

public class MarvelHero extends Hero implements Attackable {


    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((this.getEnergy() + this.getSpecial()) * this.getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        String str = super.toString()+ System.lineSeparator();
        str += String.format("####Marvel Attack Power: %.2f", this.attack());

        return str;
    }
}
