package app.manager;

import app.models.api.Arena;
import app.models.api.ComicCharacter;
import app.models.api.SuperPower;
import app.models.imp.ArenaImpl;
import app.models.imp.ComicCharacterImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WarManager implements Manager {

    private Map<String, Arena> arenas;
    private Map<String, ComicCharacter> heroes;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, SuperPower> superPowers;
    private int warsCount;
    private int warsWonByHeroes;
    private int warsWonByAntiHeroes;

    public WarManager() {
        this.arenas = new LinkedHashMap<>();
        this.heroes = new LinkedHashMap<>();
        this.antiHeroes = new LinkedHashMap<>();
        this.superPowers = new LinkedHashMap<>();
        this.warsCount = 0;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        ComicCharacter comicCharacter = this.heroes.get(characterName);
        if (comicCharacter == null) {
            comicCharacter = this.antiHeroes.get(characterName);
        }
        if (comicCharacter == null) {
            return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
        }
        if (comicCharacter.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", characterName);
        }

        return comicCharacter.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (this.heroes.containsKey(hero.getName())) {
            ComicCharacter myHero = this.heroes.get(hero.getName());
            try {
                myHero.boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
                return String.format("%s evolved!", hero.getName());
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        this.heroes.put(hero.getName(), hero);
        return String.format("%s is ready for battle!", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (this.heroes.containsKey(antiHero.getName())) {
            ComicCharacter myHero = this.heroes.get(antiHero.getName());
            try {
                myHero.boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
                return String.format("%s is getting stronger!!", antiHero.getName());
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        this.antiHeroes.put(antiHero.getName(), antiHero);

        return String.format("%s is ready for destruction!", antiHero.getName());
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenas.containsKey(arena.getArenaName())) {
            return "A battle is about to start there!";
        }

        this.arenas.put(arena.getArenaName(), arena);

        return String.format("%s is becoming a fighting ground!", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        Arena arenaObj = this.arenas.get(arena);
        ComicCharacter heroObj = this.heroes.get(hero);
        for (Arena arena1 : this.arenas.values()) {
            if (((ArenaImpl) arena1).containsHero(hero)) {
                return String.format("%s is fighting!", hero);
            }
        }
        if (heroObj.getHealth() <= 0) {
            return String.format("%s is dead!", hero);
        }
        if (arenaObj.isArenaFull()) {
            return "Arena is full!";
        }
        arenaObj.addHero(heroObj);

        return String.format("%s is fighting for your freedom in %s!", hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        Arena arenaObj = this.arenas.get(arena);
        ComicCharacter heroObj = this.antiHeroes.get(antiHero);
        if (((ArenaImpl) arenaObj).containsAntiHero(antiHero)) {
            return String.format("%s is fighting!", antiHero);
        }
        if (heroObj.getHealth() <= 0) {
            return String.format("%s is dead!", antiHero);
        }
        if (arenaObj.isArenaFull()) {
            return "Arena is full!";
        }
        arenaObj.addAntiHero(heroObj);

        return String.format("%s and his colleagues are trying to take over %s!", antiHero, arena);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowers.containsKey(superPower.getName())) {
            return "This super power already exists!";
        }

        this.superPowers.put(superPower.getName(), superPower);

        return String.format("%s added to pool!", superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        ComicCharacter comic = this.heroes.get(comicCharacter);
        if (comic == null) {
            comic = this.antiHeroes.get(comicCharacter);
        }
        if (this.heroes.values().stream().anyMatch(h -> ((ComicCharacterImpl) h).containsSuperPower(superPower)) ||
                this.antiHeroes.values().stream().anyMatch(h -> ((ComicCharacterImpl) h).containsSuperPower(superPower))) {
            throw new IllegalArgumentException(superPower + " already assigned!");
        }
        comic.addSuperPower(this.superPowers.get(superPower));

        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacter comic = this.heroes.get(characterName);
        if (comic == null) {
            comic = this.antiHeroes.get(characterName);
        }

        if (((ComicCharacterImpl) comic).getSuperPower().size() == 0) {
            return String.format("%s has no super powers!", characterName);
        }
        comic.useSuperPowers();

        return String.format("%s used his super powers!", characterName);
    }

    @Override
    public String startBattle(String arena) {
        ArenaImpl arenaObj = (ArenaImpl) this.arenas.get(arena);
        if (arenaObj.getCapacityOfAll() == 0) {
            return "SAFE ZONE!";
        }

        if (!arenaObj.fightHeroes()) {
            this.warsWonByAntiHeroes++;
            this.warsCount++;
            return String.format("Anti Heroes won the battle of %s!", arena);
        }

        this.warsWonByHeroes++;
        this.warsCount++;
        this.arenas.remove(arena);
        return String.format("Heroes won the battle of %s!", arena);
    }

    @Override
    public String endWar() {
        if (this.warsWonByHeroes >= this.warsWonByAntiHeroes) {
            return String.format("After %d battles our FRIENDLY HEROES WON!", this.warsCount);
        }

        return "WE ARE DOOMED!";
    }
}
