public class Dough {

    private static final String NORMAL_TYPES = "White Wholegrain";
    private static final String ADDITIONAL_TYPES = "Crispy Chewy Homemade";
    private static final double WHITE_CALORIES = 1.5;
    private static final double WHOLEGRAIN_CALORIES = 1.0;
    private static final double CRISPY_CALORIES = 0.9;
    private static final double CHEWY_CALORIES = 1.1;
    private static final double HOMEMADE_CALORIES = 1.0;
    private static final double INITIAL_WEIGHT = 2;

    private String type;
    private String additionCharacteristic;
    private int weight;

    public Dough(String type, String additionCharacteristic, int weight) {
        this.setType(type);
        this.setAdditionCharacteristic(additionCharacteristic);
        this.setWeight(weight);
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        if (!NORMAL_TYPES.contains(type)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }

    public String getAdditionCharacteristic() {
        return this.additionCharacteristic;
    }

    public void setAdditionCharacteristic(String additionCharacteristic) {
        if (!ADDITIONAL_TYPES.contains(additionCharacteristic)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.additionCharacteristic = additionCharacteristic;
    }

    public double getTotalCalories() {
        return INITIAL_WEIGHT * this.getWeight() * getDoughCalories(this.getType())
                * getDoughCalories(this.getAdditionCharacteristic());
    }

    private double getDoughCalories(String current) {
        switch (current) {
            case "White":
                return WHITE_CALORIES;
            case "Wholegrain":
                return WHOLEGRAIN_CALORIES;
            case "Crispy":
                return CRISPY_CALORIES;
            case "Chewy":
                return CHEWY_CALORIES;
            case "Homemade":
                return HOMEMADE_CALORIES;
        }

        return -1;
    }
}
