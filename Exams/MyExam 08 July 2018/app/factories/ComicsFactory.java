package app.factories;

import app.models.api.ComicCharacter;
import app.models.imp.DCHero;
import app.models.imp.MarvelHero;
import app.models.imp.Titan;
import app.models.imp.Villain;

public final class ComicsFactory {

    private ComicsFactory() {
    }

    public static ComicCharacter createComic(String characterName, String type, int energy, double health, double intelligence, double add) {
        switch (type) {
            case "MarvelHero":
                return new MarvelHero(characterName, energy, health, intelligence, add);
            case "DCHero":
                return new DCHero(characterName, energy, health, intelligence, add);
            case "Titan":
                return new Titan(characterName, energy, health, intelligence, add);
            case "Villain":
                return new Villain(characterName, energy, health, intelligence, add);

        }

        throw new IllegalArgumentException("Character not presented!");
    }
}
