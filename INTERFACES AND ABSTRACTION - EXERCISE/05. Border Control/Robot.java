public class Robot extends BaseCitizen {

    private String model;

    public Robot(String id, String model) {
        super(id);
        this.setModel(model);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
