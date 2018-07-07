package app.colonists;

public class Surgeon extends Medic {

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (this.getAge() > 25 && this.getAge() < 35) {
            potential += 2;
        }

        if (this.getSign().equals("precise")) {
            potential += 3;
        } else if (this.getSign().equals("butcher")) {
            potential -= 3;
        }

        return potential;
    }
}
