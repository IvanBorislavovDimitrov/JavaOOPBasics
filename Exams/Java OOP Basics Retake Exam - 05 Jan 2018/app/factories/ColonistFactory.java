package app.factories;

import app.colonists.*;

public final class ColonistFactory {

    private ColonistFactory() {

    }

    public static Colonist createColonist(String[] info) {
        switch (info[1]) {
            case "GeneralPractitioner":
                return new GeneralPractitioner(info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]), info[6]);
            case "Surgeon":
                return new Surgeon(info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]), info[6]);
            case "HardwareEngineer":
                return new HardwareEngineer(info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]));
            case "SoftwareEngineer":
                return new SoftwareEngineer(info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]));
            case "Soldier":
                return new Soldier(info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]));
        }
        return null;
    }
}
