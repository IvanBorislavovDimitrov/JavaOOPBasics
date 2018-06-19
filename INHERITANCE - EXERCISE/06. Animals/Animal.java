public class Animal {

    private static final String INVALID_PROPERTY_MESSAGE = "Invalid input!";
    private static final String SOUND_MESSAGE = "Not implemented!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException(INVALID_PROPERTY_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INVALID_PROPERTY_MESSAGE);
        }
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().equals("")) {
            throw new IllegalArgumentException(INVALID_PROPERTY_MESSAGE);
        }
        this.gender = gender;
    }

    public String produceSound() {
        return SOUND_MESSAGE;
    }

    @Override
    public String toString() {
        String type = this.getClass().getSimpleName();
        return String.format("%s\r\n%s %d %s\r\n%s", type, this.getName(), this.getAge(), this.getGender(), this.produceSound());
    }
}
