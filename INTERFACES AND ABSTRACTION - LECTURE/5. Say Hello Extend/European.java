public class European extends BasePerson {

    private static final String HELLO_MESSAGE = "Hello";

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return HELLO_MESSAGE;
    }
}
