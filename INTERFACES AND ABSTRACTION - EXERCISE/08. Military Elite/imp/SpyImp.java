package imp;

import interfaces.Spy;

public class SpyImp extends SoldierImp implements Spy {

    private String codeNumber;

    public SpyImp(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Code Number: %s", super.toString(), this.getCodeNumber());
    }
}
