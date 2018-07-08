package app.models.imp;

import app.constants.Constants;
import app.models.api.Speciable;

public abstract class Hero extends ComicCharacterImpl implements Speciable {

    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism < 0) {
            throw new IllegalArgumentException(Constants.HERO_HEROISM_NOT_VALID);
        }

        this.heroism = heroism;
    }

    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        String str = super.toString() + System.lineSeparator();
        StringBuilder sb = new StringBuilder(str);
        sb.append("###Heroism: ").append(String.format("%.2f", this.getSpecial()));

        return sb.toString();
    }
}
