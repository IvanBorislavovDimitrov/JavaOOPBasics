package app.models.imp;

import app.constants.Constants;
import app.models.api.ComicCharacter;
import app.models.api.SuperPower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> superPower;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.superPower = new ArrayList<>();
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        String regex = "[A-Za-z_]{2,12}";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException(Constants.COMIC_NAME_NOT_VALID);
        }
        this.name = name;
    }

    public int getEnergy() {
        return this.energy;
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException(Constants.COMIC_ENERGY_NOT_VALID);
        }
        this.energy = energy;
    }

    public double getHealth() {
        return this.health;
    }

    private void setHealth(double health) {
        if (health < 0) {
            throw new IllegalArgumentException(Constants.COMIC_HEALTH_NOT_VALID);
        }
        this.health = health;
    }

    public double getIntelligence() {
        return this.intelligence;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200) {
            throw new IllegalArgumentException(Constants.COMIC_INTELLIGENCE_NOT_VALID);
        }
        this.intelligence = intelligence;
    }

    public List<SuperPower> getSuperPower() {
        return Collections.unmodifiableList(this.superPower);
    }

    public void setSuperPower(List<SuperPower> superPower) {
        this.superPower = superPower;
    }

    @Override
    public String useSuperPowers() {
        if (this.superPower.isEmpty()) {
            return String.format("%s has no super powers!", this.getName());
        }
        this.superPower.forEach(s -> {
            this.setEnergy((int) (this.getEnergy() + s.getPowerPoints()));
            this.setHealth(this.getHealth() + 2 * s.getPowerPoints());
        });
        this.superPower.clear();

        return String.format("%s used his super powers!", this.getName());
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.superPower.add(superPower);
    }

    public boolean containsSuperPower(String superPower) {
        return this.superPower.stream().anyMatch(s -> s.getName().equals(superPower));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Name: ").append(this.getName()).append(System.lineSeparator());
        sb.append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f", this.getHealth(), this.getEnergy(), this.getIntelligence()));

        return sb.toString();
    }
}
