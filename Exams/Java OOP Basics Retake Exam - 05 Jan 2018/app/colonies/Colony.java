package app.colonies;

import app.colonists.Colonist;

import java.util.*;

public class Colony {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private List<Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new ArrayList<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public void setMaxFamilyCount(int maxFamilyCount) {
        this.maxFamilyCount = maxFamilyCount;
    }

    public void setMaxFamilyCapacity(int maxFamilyCapacity) {
        this.maxFamilyCapacity = maxFamilyCapacity;
    }

    public List<Family> getFamilies() {
        return this.families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        List<Colonist> colonists = new ArrayList<>();
        this.families.stream().filter(f -> f.getId().equals(familyId))
                .forEach(c -> c.getColonists().stream().
                        sorted(Comparator.comparing(Colonist::getId))
                        .forEach(colonists::add));

        return colonists;
    }

    public void addColonist(Colonist colonist) {
        Optional<Family> family = this.families.stream().filter(f -> f.getId().equals(colonist.getFamilyId())).findFirst();
        if (family.isPresent()) {
            if (family.get().getColonists().size() < this.maxFamilyCapacity) {
                family.get().getColonists().add(colonist);
            } else {
                throw new IllegalArgumentException("family is full");
            }
        } else {
            if (this.families.size() < this.maxFamilyCount) {
                Family newFam = new Family(colonist.getFamilyId());
                newFam.getColonists().add(colonist);
                this.families.add(newFam);
            } else {
                throw new IllegalArgumentException("colony is full");
            }
        }
    }

    public void removeColonist(String familyId, String memberId) {
        Family family = this.families.stream().filter(f -> f.getId().equals(familyId)).findFirst().get();
        Colonist colonist = family.getColonists().stream().filter(c -> c.getId().equals(memberId)).findFirst().get();
        family.getColonists().remove(colonist);
        if (family.getColonists().size() == 0) {
            this.families.remove(family);
        }
    }

    public void removeFamily(String id) {
        this.families.removeIf(f -> f.getId().equals(id));
    }

    public void grow(int years) {
        this.families.forEach(f -> f.getColonists().forEach(c -> c.grow(years)));
    }

    public int getPotential() {
        return this.families.stream().mapToInt(c -> c.getColonists().stream().mapToInt(Colonist::getPotential).sum()).sum();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount));
        this.families.stream().sorted((f1, f2) -> f1.getId().compareTo(f2.getId())).forEach(f -> {
            sb.append(System.lineSeparator()).append(String.format("-%s: %d/%d", f.getId(), f.getColonists().size(), this.maxFamilyCapacity));
        });

        return sb.toString();
    }

    public String getFamily(String familyId) {
        Optional<Family> family = this.families.stream().filter(f -> f.getId().equals(familyId)).findFirst();
        if (!family.isPresent()) {
            return "family does not exist";
        }

        return family.get().toString();
    }
}
