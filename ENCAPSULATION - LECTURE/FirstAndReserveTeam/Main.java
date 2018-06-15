import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        Team team = new Team("Hebar PZ");
        int peopleCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < peopleCount; i++) {
            String[] personInfo = input.readLine().split("\\s+");
            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            double salary = Double.parseDouble(personInfo[3]);
            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
                team.addPlayer(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.format("First team have %d players", team.getFirstTeam().size()));
        System.out.println(String.format("Reserve team have %d players", team.getReserveTeam().size()));
    }
}