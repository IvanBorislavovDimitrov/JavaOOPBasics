package app.colonists;

public class GeneralPractitioner extends Medic {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (this.getAge() > 15) {
            potential += 1;
        }

        if (this.getSign().equals("caring")) {
            potential += 1;
        } else if (this.getSign().equals("careless")) {
            potential -= 2;
        }

        return potential;
    }
}
