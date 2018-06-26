package imp;

import interfaces.Commando;
import interfaces.Mission;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImp extends SpecialisedSoldierImp implements Commando {

    private Set<Mission> missions;

    public CommandoImp(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Set<Mission> getMissions() {
        return Collections.unmodifiableSet(this.missions);
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Missions:");

        this.missions.forEach(m -> sb.append(System.lineSeparator()).append("  ").append(m.toString()));

        return sb.toString();
    }
}
