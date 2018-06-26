package interfaces;

import java.util.Set;

public interface Commando extends SpecialisedSoldier {
    void addMission(Mission mission);

    Set<Mission> getMissions();
}
