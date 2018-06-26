public class Chinese extends BasePerson {

    private static final String HELLO_MESSAGE = "Djydjybydjy";

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return HELLO_MESSAGE;
    }
}
