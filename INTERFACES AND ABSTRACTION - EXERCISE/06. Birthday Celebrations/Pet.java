public class Pet  extends BaseCitizen {

    private String name;

    public Pet(String birthdate, String name) {
        super(birthdate);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
