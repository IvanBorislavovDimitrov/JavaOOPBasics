package app.models.api;

public interface Arena {

    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();
}
