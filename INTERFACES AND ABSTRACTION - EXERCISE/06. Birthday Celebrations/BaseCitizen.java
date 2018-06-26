public class BaseCitizen {

    private String birthdate;

    public BaseCitizen(String id) {
        this.birthdate = id;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return this.getBirthdate();
    }
}
