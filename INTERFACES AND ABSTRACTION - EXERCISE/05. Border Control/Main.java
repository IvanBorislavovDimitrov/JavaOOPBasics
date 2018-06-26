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
            if (info.length == 2) {
                String model = info[0];
                String id = info[1];
                citizens.add(new Robot(id, model));
            } else {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                citizens.add(new Citizen(id, name, age));
            }
        }

        final String finalLine = input.readLine();
        citizens.stream().filter(x -> x.getId().endsWith(finalLine)).forEach(System.out::println);

    }
}
