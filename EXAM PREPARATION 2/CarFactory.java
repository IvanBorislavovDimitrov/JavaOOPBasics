public final class CarFactory {

    private static final String PERFORMANCE_CAR = "Performance";
    private static final String SHOW_CAR = "Show";

    private CarFactory() {
    }

    public static Car createCar(String type, String brand, String model, int year,
                                int horsepower, int acceleration, int suspension, int durability) {
        switch (type) {
            case PERFORMANCE_CAR:
                return new PerformanceCar(brand, model, year, horsepower, acceleration, suspension, durability);
            case SHOW_CAR:
                return new ShowCar(brand, model, year, horsepower,
                        acceleration, suspension, durability);
        }

        return null;
    }
}
