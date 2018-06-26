import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] characterInfo = input.readLine().split(" +\\| +");
        String username = characterInfo[0];
        String type = characterInfo[1];
        int level = Integer.parseInt(characterInfo[3]);

        Base base = null;
        switch (type) {
            case "Demon":
                double specialPoints = Double.parseDouble(characterInfo[2]);
                base = new Demon(username, specialPoints, level);
                break;
            case "Archangel":
                int mana = Integer.parseInt(characterInfo[2]);
                base = new Archangel(username, mana, level);
                break;
        }

        System.out.println(base);
    }
}
