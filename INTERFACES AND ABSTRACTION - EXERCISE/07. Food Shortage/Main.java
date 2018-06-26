import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int buyersCount = Integer.parseInt(input.readLine());
        List<Buyer> buyers = new ArrayList<>();
         for (int i = 0; i < buyersCount; i++) {
            String[] info = input.readLine().split("\\s+");
            if (info.length == 4) {
                Buyer buyer = new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3]);
                buyers.add(buyer);
            } else {
                Buyer buyer = new Rebel(info[0], Integer.parseInt(info[1]), info[2]);
                buyers.add(buyer);
            }
        }

        String line;
         while (!"End".equals(line = input.readLine())) {
             final String finalLine = line;
             Optional<Buyer> first = buyers.stream().filter(x -> x.getName().equals(finalLine)).findFirst();
             first.ifPresent(Buyer::buyFood);
         }

        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
