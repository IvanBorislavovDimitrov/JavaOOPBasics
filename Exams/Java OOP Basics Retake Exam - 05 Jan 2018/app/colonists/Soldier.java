package app.colonists;

public class Soldier extends Colonist {

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return this.getTalent() + 3 + 3;
    }
}
