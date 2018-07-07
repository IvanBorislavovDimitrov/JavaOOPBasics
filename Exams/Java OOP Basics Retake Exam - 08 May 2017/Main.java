import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Executor executor = new Executor();
        String line;
        while (!"Quit".equals(line = input.readLine())) {
            String[] info = line.split("\\s+");
            switch (info[0]) {
                case "Bender":
                    executor.createBender(info[1], info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
                    break;
                case "Monument":
                    executor.createMonument(info[1], info[2], Integer.parseInt(info[3]));
                    break;
                case "Status":
                    System.out.println(executor.status(info[1]));
                    break;
                case "War":
                    executor.war(info[1]);
                    break;
            }
        }

        System.out.println(executor.printWars());
    }
}
