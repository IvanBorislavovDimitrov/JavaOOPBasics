package interfaces;

import java.util.List;

public interface Engineer extends SpecialisedSoldier {
    List<Repair> getRepairs();

    void addRepair(Repair repair);
}
