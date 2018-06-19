public class Kitten extends Cat {

    private static final String KITTEN_GENDER = "Female";
    private static final String SOUND_MESSAGE = "Miau";

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Kitten(String name, int age) {
        this(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return SOUND_MESSAGE;
    }
}
