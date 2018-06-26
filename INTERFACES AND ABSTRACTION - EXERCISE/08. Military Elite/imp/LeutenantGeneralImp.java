package imp;

import interfaces.LeutenantGeneral;
import interfaces.Private;
import interfaces.Soldier;

import java.util.*;

public class LeutenantGeneralImp extends PrivateImp implements LeutenantGeneral {

    private List<Soldier> privates;

    public LeutenantGeneralImp(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Soldier privatePerson) {
        this.privates.add(privatePerson);
    }

    @Override
    public List<Soldier> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    public void setPrivates(List<Soldier> privates) {
        this.privates = privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:");
        this.privates.sort(Comparator.comparing(Soldier::getId, Comparator.reverseOrder()));
        this.privates.forEach(p -> sb.append(System.lineSeparator()).append("  ").append(p.toString()));

        return sb.toString();
    }
}
