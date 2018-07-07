public abstract class Bender {

    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public abstract double getTotalPower();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
