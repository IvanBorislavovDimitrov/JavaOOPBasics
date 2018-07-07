import app.AnimalCenterManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        AnimalCenterManager animalCenterManager = AnimalCenterManager.class.getDeclaredConstructor().newInstance();
//        io(input, animalCenterMana    ger);
        io1(input,animalCenterManager);
    }

    private static void io1(BufferedReader input, AnimalCenterManager animalCenterManager) throws IOException {
        String line;
        while (!"Paw Paw Pawah".equals(line = input.readLine())) {
            String[] info = line.split(" \\| ");
            switch (info[0]) {
                case "RegisterCastrationCenter":
                    animalCenterManager.registerCastrationCenter(info[1]);
                    break;
                case "SendForCastration":
                    animalCenterManager.sendForCastration(info[1], info[2]);
                    break;
                case "Castrate":
                    animalCenterManager.castrate(info[1]);
                    break;
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(info[1]);
                    break;
                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(info[1]);
                    break;
                case "RegisterDog":
                    animalCenterManager.registerDog(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            info[4]);
                    break;
                case "RegisterCat":
                    animalCenterManager.registerCat(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            info[4]);
                    break;
                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(info[1], info[2]);
                    break;
                case "Cleanse":
                    animalCenterManager.cleanse(info[1]);
                    break;
                case "Adopt":
                    animalCenterManager.adopt(info[1]);
                    break;
                case "CastrationStatistics":
                    animalCenterManager.castrationStatistics();
                    break;
            }
        }

        animalCenterManager.printStatistics();
    }

    private static void io(BufferedReader input, AnimalCenterManager animalCenterManager) throws IOException {
        String line;
        while (!"Paw Paw Pawah".equals(line = input.readLine())) {
            String[] info = line.split(" \\| ");
            switch (info[0]) {
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(info[1]);
                    break;
                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(info[1]);
                    break;
                case "RegisterDog":
                    animalCenterManager.registerDog(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            info[4]);
                    break;
                case "RegisterCat":
                    animalCenterManager.registerCat(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            info[4]);
                    break;
                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(info[1], info[2]);
                    break;
                case "Cleanse":
                    animalCenterManager.cleanse(info[1]);
                    break;
                case "Adopt":
                    animalCenterManager.adopt(info[1]);
                    break;
            }
        }

        animalCenterManager.printStatistics();
    }
}
