package app;

import app.model.main_logic.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new Manager();
        String line;
        while (!"System Split".equals(line = input.readLine())) {
            String[] info = line.split("[(), ]+");
            String command = info[0];
            switch (command) {
                case "RegisterPowerHardware":
                    manager.registerPowerHardware(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                    break;
                case "RegisterHeavyHardware":
                    manager.registerHeavyHardware(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                    break;
                case "RegisterExpressSoftware":
                    manager.registerExpressSoftware(info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                    break;
                case "RegisterLightSoftware":
                    manager.registerLightSoftware(info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                    break;
                case "ReleaseSoftwareComponent":
                    manager.releaseSoftwareComponent(info[1], info[2]);
                    break;
                case "Analyze":
                    System.out.println(manager.analyze());
                    break;
                case "Dump":
                    manager.dump(info[1]);
                    break;
                case "Restore":
                    manager.restore(info[1]);
                    break;
                case "Destroy":
                    manager.destroy(info[1]);
                    break;
                case "DumpAnalyze":
                    System.out.println(manager.dumpAnalyze());
                    break;
            }
        }

        System.out.println(manager.systemSplit());
    }
}
