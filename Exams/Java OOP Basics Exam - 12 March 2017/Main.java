import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();
        String line;
        while (!"Cops Are Here".equals(line = input.readLine())) {
            String[] infoLine = line.split("\\s+");
            switch (infoLine[0]) {
                case "register":
                    carManager.register(Integer.parseInt(infoLine[1]),
                            infoLine[2], infoLine[3], infoLine[4], Integer.parseInt(infoLine[5]),
                            Integer.parseInt(infoLine[6]), Integer.parseInt(infoLine[7]),
                            Integer.parseInt(infoLine[8]), Integer.parseInt(infoLine[9]));
                    break;
                case "check":
                    System.out.println(carManager.check(Integer.parseInt(infoLine[1])));
                    break;
                case "open":
                    try {
                        if (infoLine.length == 6) {
                            carManager.open(Integer.parseInt(infoLine[1]),
                                    infoLine[2], Integer.parseInt(infoLine[3]), (infoLine[4]),
                                    Integer.parseInt(infoLine[5]));
                        } else {
                            carManager.open(Integer.parseInt(infoLine[1]),
                                    infoLine[2], Integer.parseInt(infoLine[3]), (infoLine[4]),
                                    Integer.parseInt(infoLine[5]), Integer.parseInt(infoLine[6]));
                        }

                    } catch (IllegalArgumentException e) {
                    }
                    break;
                case "participate":
                    try {
                        carManager.participate(Integer.parseInt(infoLine[1]), Integer.parseInt(infoLine[2]));
                    } catch (IllegalArgumentException e) {
                    }
                    break;
                case "start":
                    try {
                        System.out.println(carManager.start(Integer.parseInt(infoLine[1])));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "park":
                    carManager.park(Integer.parseInt(infoLine[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(infoLine[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(infoLine[1]), (infoLine[2]));
                    break;
            }
        }
    }
}
