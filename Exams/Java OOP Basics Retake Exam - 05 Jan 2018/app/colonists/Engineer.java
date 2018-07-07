package app.colonists;

public abstract class Engineer extends Colonist {

    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = this.getTalent() + 3;
        if (this.getAge() > 30) {
            potential += 2;
        }

        return potential;
    }
}
