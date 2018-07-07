package app.colonies;

import app.colonists.Colonist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Family {

    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Colonist> getColonists() {
        return this.colonists;
    }

    public void setColonists(List<Colonist> colonists) {
        this.colonists = colonists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(":");
        this.colonists.stream().sorted(Comparator.comparing(Colonist::getId))
                .forEach(c -> {
                    sb.append(System.lineSeparator()).append(c.toString());
                });

        return sb.toString();
    }
}
