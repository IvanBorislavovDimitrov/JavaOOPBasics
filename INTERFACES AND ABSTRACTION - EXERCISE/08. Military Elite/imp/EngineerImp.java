package imp;

import interfaces.Engineer;
import interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImp extends SpecialisedSoldierImp implements Engineer {

    private List<Repair> repairs;

    public EngineerImp(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:");
        this.repairs.forEach(r -> sb.append(System.lineSeparator()).append("  ").append(r.toString()));

        return sb.toString();
    }
}
