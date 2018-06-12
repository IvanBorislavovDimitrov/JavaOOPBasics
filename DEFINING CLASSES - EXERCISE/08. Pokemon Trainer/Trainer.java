import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trainer implements Comparable<Trainer> {

    private String name;
    private int numberOfBadges;
    private Set<Pokemon> pokemons;

    public Trainer(String name) {
        this(name, 0);
    }

    public Trainer(String name, int numberOfBadges) {
        this(name, numberOfBadges, new HashSet<>());
    }

    public Trainer(String name, int numberOfBadges, Set<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public int compareTo(Trainer o) {
        return Integer.compare(o.getNumberOfBadges(), this.getNumberOfBadges());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getNumberOfBadges(), this.getPokemons().size());
    }
}
