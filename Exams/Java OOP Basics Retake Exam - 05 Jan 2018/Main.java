import app.colonies.Colony;
import app.colonists.Colonist;
import app.colonists.GeneralPractitioner;
import app.colonists.Medic;
import app.factories.ColonistFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] dims = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Colony colony = new Colony(dims[0], dims[1]);
        String line;
        while (!"end".equals(line = input.readLine())) {
            String[] info = line.split("\\s+");
            switch (info[0]) {
                case "insert":
                    try {
                        Colonist colonist = ColonistFactory.createColonist(info);
                        colony.addColonist(colonist);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "remove":
                    remove(colony, info);
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(info[1]));
                    break;
                case "potential":
                    System.out.println(String.format("potential: %d", colony.getPotential()));
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    System.out.println(colony.getFamily(info[1]));
                    break;
            }
        }
    }

    private static void remove(Colony colony, String[] info) {
        switch (info[1]) {
            case "family":
                colony.removeFamily(info[2]);
                return;
            case "colonist":
                colony.removeColonist(info[2], info[3]);
        }
    }
}
