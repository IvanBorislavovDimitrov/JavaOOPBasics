public class Bulgarian extends BasePerson {

    private static final String HELLO_MESSAGE = "Здравей";

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return HELLO_MESSAGE;
    }
}
