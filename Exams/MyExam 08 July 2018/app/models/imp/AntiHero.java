package app.models.imp;

import app.constants.Constants;
import app.models.api.Speciable;

public abstract class AntiHero extends ComicCharacterImpl implements Speciable {

    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness < 0) {
            throw new IllegalArgumentException(Constants.ANTIHERO_EVILNESS_NOT_VALID);
        }

        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    @Override
    public String toString() {
        String str = super.toString() + System.lineSeparator();
        str += "###Evilness: " + (String.format("%.2f", this.getSpecial()));

        return str;
    }
}
