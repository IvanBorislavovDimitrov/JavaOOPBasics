package app.colonists;

public abstract class Medic extends Colonist {

    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    @Override
    public int getPotential() {
        return this.getTalent() + 2;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
