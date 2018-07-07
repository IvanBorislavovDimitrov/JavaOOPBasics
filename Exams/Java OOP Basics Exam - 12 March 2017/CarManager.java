import java.util.*;

public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction,
                         int horsepower, int acceleration, int suspension, int durability) {
        Car car = CarFactory.createCar(type, brand, model, yearOfProduction, horsepower,
                acceleration, suspension, durability);
        this.cars.put(id, car);
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.createRace(type, length, route, prizePool);
        this.races.put(id, race);
    }

    public void open(int id, String type, int length, String route, int prizePool, int opt) {
        Race race = RaceFactory.createRaceSpecial(type, length, route, prizePool, opt);
        this.races.put(id, race);
    }

    public void participate(int carId, int raceId) {
        Car car = this.cars.get(carId);
        Race race = this.races.get(raceId);
        if (this.garage.getCars().contains(car)) {
            return;
        }
        if (race instanceof TimeLimitRace && race.getParticipants().size() == 1) {
            throw new IllegalArgumentException();
        }
        race.getParticipants().add(car);
    }

    public String start(int id) {
        Race race = this.races.get(id);
        if (race == null) {
            throw new IllegalArgumentException();
        }
        String ra =  race.race(race);
        this.races.remove(id);

        return ra;
    }

    public void park(int id) {
        List<Car> allCars = new ArrayList<>();
        this.races.values().forEach(r -> allCars.addAll(r.getParticipants()));
        Car car = this.cars.get(id);
        if (allCars.contains(car)) {
            return;
        }

        this.garage.getCars().add(car);
    }

    public void unpark(int id) {
        Car car = this.cars.get(id);
        this.garage.getCars().remove(car);
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : this.garage.getCars()) {
            if (car instanceof ShowCar) {
                car.setHorsePower(car.getHorsePower() + tuneIndex);
                car.setSuspension(car.getSuspension() + tuneIndex / 2);
                ((ShowCar) car).setStars(((ShowCar) car).getStars() + tuneIndex);
            } else if (car instanceof PerformanceCar) {
                ((PerformanceCar) car).increaseHp(tuneIndex);
                ((PerformanceCar) car).increaseSusp(tuneIndex / 2);
                ((PerformanceCar) car).getAddOns().add(addOn);
            }
        }
    }
}
