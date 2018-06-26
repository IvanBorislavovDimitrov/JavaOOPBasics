package imp;

import interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImp extends PrivateImp implements SpecialisedSoldier {

    private static final String INVALID_CORPS_MESSAGE = "Invalid corps";
    private static final String AIRFORCES = "Airforces";
    private static final String MARINES = "Marines";

    private String corps;

    public SpecialisedSoldierImp(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public String getCorps() {
        return this.corps;
    }

    @Override
    public void setCorps(String corps) {
        if (!corps.equals(AIRFORCES) && !corps.equals(MARINES)) {
            throw new IllegalArgumentException(INVALID_CORPS_MESSAGE);
        }
        this.corps = corps;
    }
}
