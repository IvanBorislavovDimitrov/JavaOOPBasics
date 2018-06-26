import imp.*;
import interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String END_COMMAND = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiers = new ArrayList<>();
        String line;
        while (!END_COMMAND.equals(line = input.readLine())) {
            String[] soldierInfo = line.split("\\s+");
            executeCommand(soldiers, soldierInfo);
        }

        printSoldiers(soldiers);
    }

    private static void printSoldiers(List<Soldier> soldiers) {
        soldiers.forEach(System.out::println);
    }

    private static void executeCommand(List<Soldier> soldiers, String[] soldierInfo) {
        String soldierType = soldierInfo[0];

        switch (soldierType) {
            case "Private":
                Private privateSoldier = createPrivate(soldierInfo);
                soldiers.add(privateSoldier);
                break;
            case "LeutenantGeneral":
                LeutenantGeneral leutenantGeneral = createLeutenantGeneral(soldiers, soldierInfo);
                soldiers.add(leutenantGeneral);
                break;
            case "Engineer":
                Engineer engineer = createEngineer(soldierInfo);
                if (engineer != null) {
                    soldiers.add(engineer);
                }
                break;
            case "Commando":
                Commando commando = createCommando(soldierInfo);
                if (commando != null) {
                    soldiers.add(commando);
                }
                break;
            case "Spy":
                Spy spy = createSpy(soldierInfo);
                soldiers.add(spy);
                break;
        }
    }

    private static Spy createSpy(String[] soldierInfo) {
        String id = soldierInfo[1];
        String firstName = soldierInfo[2];
        String lastName = soldierInfo[3];
        String codeNumber = soldierInfo[4];

        return new SpyImp(id, firstName, lastName, codeNumber);
    }

    private static Commando createCommando(String[] soldierInfo) {
        String id = soldierInfo[1];
        String firstName = soldierInfo[2];
        String lastName = soldierInfo[3];
        double salary = Double.parseDouble(soldierInfo[4]);
        String corps = soldierInfo[5];
        Commando commando = null;
        try {
            commando = new CommandoImp(id, firstName, lastName, salary, corps);
            String[] missions = Arrays.stream(soldierInfo).skip(6).toArray(String[]::new);
            for (int i = 0; i < missions.length; i += 2) {
                String mission = missions[i];
                String missionState = missions[i + 1];
                try {
                    commando.addMission(new MissionImp(mission, missionState));
                } catch (IllegalArgumentException ignored) {
                }
            }
        } catch (IllegalArgumentException ignored) {

        }

        return commando;
    }

    private static Engineer createEngineer(String[] soldierInfo) {
        String id = soldierInfo[1];
        String firstName = soldierInfo[2];
        String lastName = soldierInfo[3];
        double salary = Double.parseDouble(soldierInfo[4]);
        String corps = soldierInfo[5];
        String[] repairs = Arrays.stream(soldierInfo).skip(6).toArray(String[]::new);
        Engineer engineer = null;
        try {
            engineer = new EngineerImp(id, firstName, lastName, salary, corps);
            for (int i = 0; i < repairs.length; i += 2) {
                String repairPart = repairs[i];
                int repairHours = Integer.parseInt(repairs[i + 1]);
                try {
                    engineer.addRepair(new RepairImp(repairPart, repairHours));
                } catch (IllegalArgumentException ignored) {
                }
            }
        } catch (IllegalArgumentException ignored) {
        }

        return engineer;
    }

    private static LeutenantGeneral createLeutenantGeneral(List<Soldier> soldiers, String[] soldierInfo) {
        String id = soldierInfo[1];
        String firstName = soldierInfo[2];
        String lastName = soldierInfo[3];
        double salary = Double.parseDouble(soldierInfo[4]);
        String[] ids = Arrays.stream(soldierInfo).skip(5).toArray(String[]::new);
        LeutenantGeneral leutenantGeneral = new LeutenantGeneralImp(id, firstName, lastName, salary);

        Arrays.stream(ids).forEach(x -> {
            Soldier soldier = soldiers.stream().filter(s -> s.getId().equals(x)).findFirst().get();
            leutenantGeneral.addPrivate(soldier);
        });

        return leutenantGeneral;
    }

    private static Private createPrivate(String[] soldierInfo) {
        String id = soldierInfo[1];
        String firstName = soldierInfo[2];
        String lastName = soldierInfo[3];
        double salary = Double.parseDouble(soldierInfo[4]);

        return new PrivateImp(id, firstName, lastName, salary);
    }
}
