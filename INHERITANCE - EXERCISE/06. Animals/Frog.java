public class Frog extends Animal {

    private static final String SOUND_MESSAGE = "Frogggg";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND_MESSAGE;
    }
}
