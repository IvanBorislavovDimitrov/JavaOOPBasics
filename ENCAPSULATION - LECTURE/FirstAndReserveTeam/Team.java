import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public Team(String name, List<Person> firstTeam, List<Person> reserveTeam) {
        this.name = name;
        this.firstTeam = firstTeam;
        this.reserveTeam = reserveTeam;
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    public String getName() {
        return name;
    }

    public Collection<Person> getFirstTeam() {
        return Collections.unmodifiableCollection(this.firstTeam);
    }

    public Collection<Person> getReserveTeam() {
        return Collections.unmodifiableCollection(this.reserveTeam);
    }
}
