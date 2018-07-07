package app.colonists;

public class HardwareEngineer extends Engineer {

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (this.getAge() < 18) {
            potential += 2;
        }

        return potential;
    }
}
