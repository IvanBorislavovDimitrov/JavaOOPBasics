public class Citizen extends BaseCitizen {

    private String name;
    private int age;

    public Citizen(String birthdate, String name, int age) {
        super(birthdate);
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
