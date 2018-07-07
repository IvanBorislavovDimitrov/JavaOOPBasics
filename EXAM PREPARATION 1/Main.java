import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();
        String line;
        while (!"BEER IS COMING".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String command = lineInfo[0];
            switch (command) {
                case "createOrganism":
                    String organismName = lineInfo[1];
                    try {
                        String s = healthManager.createOrganism(organismName);
                        if (s.equals("")) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println(s);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "addCluster":
                    try {
                        String s = healthManager.addCluster(lineInfo[1], lineInfo[2],
                                Integer.parseInt(lineInfo[3]), Integer.parseInt(lineInfo[4]));
                        if (s.equals("")) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println(s);
                    } catch (Exception ignored) {
                    }

                    break;
                case "addCell":
                    try {
                        String s = healthManager.addCell(lineInfo[1], lineInfo[2], lineInfo[3],
                                lineInfo[4], Integer.parseInt(lineInfo[5]), Integer.parseInt(lineInfo[6]),
                                Integer.parseInt(lineInfo[7]), Integer.parseInt(lineInfo[8]));
                        if (s.equals("")) {
                            throw new IllegalArgumentException();
                        }

                        System.out.println(s);
                    } catch (Exception ignored) {
                    }
                    break;
                case "activateCluster":
                    try {
                        String s = healthManager.activateCluster(lineInfo[1]);
                        if (s.equals("")) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println(s);
                    } catch (Exception e) {

                    }
                    break;
                case "checkCondition":
                    try {
                        String s = healthManager.checkCondition(lineInfo[1]);
                        if (s.equals("")) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println(s);
                    } catch (Exception e) {
                    }
                    break;
            }
        }
    }
}
