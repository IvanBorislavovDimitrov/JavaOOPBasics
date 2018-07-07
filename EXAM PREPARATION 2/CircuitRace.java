import java.util.Comparator;
import java.util.List;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }


    @Override
    public String race(Race race) {
        List<Car> racers = race.getParticipants();
        for (int i = 0; i < this.getLaps(); i++) {
            racers.forEach(r -> r.setDurability(r.getDurability() - race.getLength() * race.getLength()));
        }

        List<Car> sortedParticipants = race.getParticipants();
        sortedParticipants.sort((p1, p2) -> {
            int p1Overall = (p1.getHorsePower() / p1.getAcceleration()) + (p1.getSuspension() + p1.getDurability());
            int p2Overall = (p2.getHorsePower() / p2.getAcceleration()) + (p2.getSuspension() + p2.getDurability());

            return Integer.compare(p2Overall, p1Overall);
        });

        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength() * this.getLaps()).append(System.lineSeparator());
        for (int i = 0; i < Math.min(4, racers.size()); i++) {
            Car car = racers.get(i);
            int perfPoints = (car.getHorsePower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
            if (i == 0) {
                int profit = (race.getPrizePool() * 40) / 100;
                sb.append(String.format("1. %s %s %dPP - $%d",
                        car.getBrand(), car.getModel(), perfPoints, profit));
            } else if (i == 1) {
                int profit = (race.getPrizePool() * 30) / 100;
                sb.append(System.lineSeparator())
                        .append(String.format("2. %s %s %dPP - $%d",
                                car.getBrand(), car.getModel(), perfPoints, profit));
            } else if (i == 2) {
                int profit = (race.getPrizePool() * 20) / 100;
                sb.append(System.lineSeparator())
                        .append(String.format("3. %s %s %dPP - $%d",
                                car.getBrand(), car.getModel(), perfPoints, profit));
            } else {
                int profit = (race.getPrizePool() * 10) / 100;
                sb.append(System.lineSeparator())
                        .append(String.format("4. %s %s %dPP - $%d",
                                car.getBrand(), car.getModel(), perfPoints, profit));
            }
        }

        return sb.toString();
    }

    public int getLaps() {
        return this.laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
}
