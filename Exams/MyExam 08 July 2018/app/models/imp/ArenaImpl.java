package app.models.imp;

import app.models.api.Arena;
import app.models.api.Attackable;
import app.models.api.ComicCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArenaImpl implements Arena {

    private String arenaName;

    private List<ComicCharacter> heroes;

    private List<ComicCharacter> antiHeroes;

    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
    }

    public boolean containsHero(String heroName) {
        return this.heroes.stream().map(h -> h.getName()).anyMatch(h -> h.equals(heroName));
    }

    public boolean containsAntiHero(String antiHeroName) {
        return this.antiHeroes.stream().map(h -> h.getName()).anyMatch(h -> h.equals(antiHeroName));
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        return this.heroes.size() + this.antiHeroes.size() > this.capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        if (this.getCapacityOfAll() >= this.getCapacity()) {
            throw new IllegalArgumentException("Arena is full!");
        }
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        if (this.getCapacityOfAll() >= this.getCapacity()) {
            throw new IllegalArgumentException("Arena is full!");
        }
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        boolean heroesAttackFirst = this.heroes.size() >= this.antiHeroes.size();
        while (this.heroes.size() > 0 && this.antiHeroes.size() > 0) {
            if (heroesAttackFirst) {
                for (int i = 0; i < Math.min(this.antiHeroes.size(), this.heroes.size()); i++) {
                    ComicCharacter antiHero = this.antiHeroes.get(i);
                    double antiHeroAttack = ((Attackable) antiHero).attack();
                    this.heroes.get(i).takeDamage(antiHeroAttack);
                }
            } else {
                for (int i = 0; i < Math.min(this.antiHeroes.size(), this.heroes.size()); i++) {
                    ComicCharacter antiHero = this.heroes.get(i);
                    double antiHeroAttack = ((Attackable) antiHero).attack();
                    this.antiHeroes.get(i).takeDamage(antiHeroAttack);
                }
            }

            this.heroes = this.heroes.stream().filter(h -> h.getHealth() > 0).collect(Collectors.toList());;
            this.antiHeroes = this.antiHeroes.stream().filter(h -> h.getHealth() > 0).collect(Collectors.toList());;

            heroesAttackFirst = !heroesAttackFirst;
        }

        return this.heroes.size() != 0;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public List<ComicCharacter> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<ComicCharacter> heroes) {
        this.heroes = heroes;
    }

    public List<ComicCharacter> getAntiHeroes() {
        return this.antiHeroes;
    }

    public void setAntiHeroes(List<ComicCharacter> antiHeroes) {
        this.antiHeroes = antiHeroes;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCapacityOfAll() {
        return this.heroes.size() + this.antiHeroes.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
