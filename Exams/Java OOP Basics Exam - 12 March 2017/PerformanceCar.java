import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration,
                          int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.setHorsePower(this.getHorsePower() * 50 / 100 + this.getHorsePower());
        this.setSuspension( this.getSuspension() - this.getSuspension() * 25 / 100);
        this.addOns = new ArrayList<>();
    }

    public void increaseHp(int pw) {
        this.setHorsePower(super.getHorsePower() + pw);
    }

    public void increaseSusp(int s) {
        this.setSuspension(super.getSuspension() + s);
    }

    public List<String> getAddOns() {
        return this.addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Add-ons: ");
        if (this.addOns.isEmpty()) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.addOns));
        }

        return sb.toString();
    }
}
