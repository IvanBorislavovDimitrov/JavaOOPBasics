import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Car> cars;

    public Garage() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
