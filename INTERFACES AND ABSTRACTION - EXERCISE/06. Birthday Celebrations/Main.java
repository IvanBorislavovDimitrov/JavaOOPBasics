import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<BaseCitizen> citizens = new ArrayList<>();
        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] info = line.split("\\s+");
            String type = info[0];
            switch (type) {
                case "Citizen":
                    BaseCitizen b = new Citizen(info[4], info[1], Integer.parseInt(info[2]));
                    citizens.add(b);
                    break;
                case "Pet":
                    b = new Pet(info[2], info[1]);
                    citizens.add(b);
                    break;
            }
        }

        final String finalLine = input.readLine();

        citizens.stream().filter(x -> x.getBirthdate().endsWith(finalLine)).forEach(System.out::println);

    }
}
