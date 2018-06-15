import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;
    private static final String ILLEGAL_NAME_MESSAGE = "A name should not be empty.";
    public static final String PLAYER_IS_NOT_IN_TEAM_MESSAGE = "Player %s is not in %s team.";
    public static final String TEAM_IS_MISSING = "Team %s does not exist.";

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE);
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean playerRemoved = false;
        for (int i = this.players.size() - 1; i >= 0; i--) {
            if (this.players.get(i).getName().equals(name)) {
                this.players.remove(i);
                playerRemoved = true;
                break;
            }
        }

        if (!playerRemoved) {
            throw new IllegalArgumentException(String.format(PLAYER_IS_NOT_IN_TEAM_MESSAGE, name, this.getName()));
        }
    }

    public long overall() {
        return Math.round(this.players.stream().mapToDouble(Player::averageSkills).average().orElse(0));
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.overall());
    }
}
