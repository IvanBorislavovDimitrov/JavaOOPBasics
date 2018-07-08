package app.models.api;

public interface ComicCharacter {

    void takeDamage(double damage);

    void boostCharacter(int energy, double health, double intelligence);

    String getName();

    int getEnergy();

    double getHealth();

    double getIntelligence();

    String useSuperPowers();

    double getSpecial();

    void addSuperPower(SuperPower superPower);
}
