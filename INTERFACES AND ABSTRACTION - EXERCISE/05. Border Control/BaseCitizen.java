public class BaseCitizen {

    private String id;

    public BaseCitizen(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
