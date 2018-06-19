public class Human {

    private static final String FIRST_NAME_STARTS_WITH_UPPER_EXCEPTION_MESSAGE = "Should be 4 or more than 4 symbols";
    private static final String FIRST_NAME_IS_AT_LEAST_FOUR_SYMBOLS_EXCEPTION_MESSAGE = "Should be 4 or more than 4 symbols";
    private static final String LAST_NAME_STARTS_WITH_UPPER_EXCEPTION_MESSAGE = "Expected upper case letter!Argument: lastName";
    private static final String LAST_NAME_IS_AT_LEAST_THREE_SYMBOLS_EXCEPTION_MESSAGE = "Expected length at least 3 symbols!Argument: lastName";


    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() < 4) {
            throw new IllegalArgumentException(FIRST_NAME_IS_AT_LEAST_FOUR_SYMBOLS_EXCEPTION_MESSAGE);
        }
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(FIRST_NAME_STARTS_WITH_UPPER_EXCEPTION_MESSAGE);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() < 3) {
            throw new IllegalArgumentException(LAST_NAME_IS_AT_LEAST_THREE_SYMBOLS_EXCEPTION_MESSAGE);
        }
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(LAST_NAME_STARTS_WITH_UPPER_EXCEPTION_MESSAGE);
        }
        this.lastName = lastName;
    }
}
