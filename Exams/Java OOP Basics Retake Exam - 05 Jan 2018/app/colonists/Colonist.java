package app.colonists;

public abstract class Colonist {

    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    abstract public int getPotential();

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void grow(int years) {
        this.age += years;
    }

    @Override
    public String toString() {
        return String.format("-%s: %d", this.getId(), this.getPotential());
    }
}
