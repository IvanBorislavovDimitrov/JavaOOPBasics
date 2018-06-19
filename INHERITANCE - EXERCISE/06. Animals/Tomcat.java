public class Tomcat extends Cat {

    private static final String TOMCAT_GENDER = "Male";
    private static final String SOUND_MESSAGE = "Give me one million b***h";

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Tomcat(String name, int age) {
        this(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return SOUND_MESSAGE;
    }
}
