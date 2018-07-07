import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Car> cars;

    public Garage() {
        this.cars = new ArrayList<>();
    }

    protected List<Car> getCars() {
        return this.cars;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
