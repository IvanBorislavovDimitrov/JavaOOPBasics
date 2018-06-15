import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Team> teams = new ArrayList<>();
        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] commandInfo = line.split(";");
            try {
                executeCommand(teams, commandInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void executeCommand(List<Team> teams, String[] commandInfo) {
        String command = commandInfo[0];
        switch (command) {
            case "Team":
                String teamName = commandInfo[1];
                addTeam(teams, teamName);
                break;
            case "Add":
                addPlayer(teams, commandInfo);
                break;
            case "Remove":
                removePlayer(teams, commandInfo);
                break;
            case "Rating":
                rating(teams, commandInfo);
                break;
        }
    }

    private static void rating(List<Team> teams, String[] commandInfo) {
        String teamName = commandInfo[1];
        Optional<Team> team = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst();
        if (team.isPresent()) {
            System.out.println(team.get());
        } else {
            throw new IllegalArgumentException(String.format(Team.TEAM_IS_MISSING, teamName));
        }
    }

    private static void removePlayer(List<Team> teams, String[] commandInfo) {
        String teamName = commandInfo[1];
        String playerName = commandInfo[2];
        Optional<Team> team = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst();
        if (team.isPresent()) {
            team.get().removePlayer(playerName);
        } else {
            throw new IllegalArgumentException(String.format(Team.PLAYER_IS_NOT_IN_TEAM_MESSAGE, team, teamName));
        }
    }

    private static void addPlayer(List<Team> teams, String[] commandInfo) {
        String teamName = commandInfo[1];
        String playerName = commandInfo[2];
        int endurance = Integer.parseInt(commandInfo[3]);
        int sprint = Integer.parseInt(commandInfo[4]);
        int dribble = Integer.parseInt(commandInfo[5]);
        int passing = Integer.parseInt(commandInfo[6]);
        int shooting = Integer.parseInt(commandInfo[7]);
        Optional<Team> team = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst();
        if (team.isPresent()) {
            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            team.get().addPlayer(player);
        } else {
            throw new IllegalArgumentException(String.format(Team.TEAM_IS_MISSING, teamName));
        }
    }

    private static void addTeam(List<Team> teams, String teamName) {
        Team team = new Team(teamName);
        teams.add(team);
    }
}