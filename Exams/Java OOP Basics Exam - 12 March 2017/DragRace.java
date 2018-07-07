import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String race(Race race) {
        if (race.getParticipants().isEmpty()) {
            throw new IllegalArgumentException("Cannot start the race with zero participants.");
        }

        List<Car> sortedParticipants = race.getParticipants();
        sortedParticipants.sort((p1, p2) -> {
            int p1Overall = (p1.getHorsePower() / p1.getAcceleration());
            int p2Overall = (p2.getHorsePower() / p2.getAcceleration());

            return Integer.compare(p2Overall, p1Overall);
        });

        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        for (int i = 0; i < Math.min(3, sortedParticipants.size()); i++) {
            Car car = sortedParticipants.get(i);
            int perfPoints = (car.getHorsePower() / car.getAcceleration());
            if (i == 0) {
                int profit = (race.getPrizePool() * 50) / 100;
                sb.append(String.format("1. %s %s %dPP - $%d",
                        car.getBrand(), car.getModel(), perfPoints, profit));
            } else if (i == 1) {
                int profit = (race.getPrizePool() * 30) / 100;
                sb.append(System.lineSeparator())
                        .append(String.format("2. %s %s %dPP - $%d",
                                car.getBrand(), car.getModel(), perfPoints, profit));
            } else {
                int profit = (race.getPrizePool() * 20) / 100;
                sb.append(System.lineSeparator())
                        .append(String.format("3. %s %s %dPP - $%d",
                                car.getBrand(), car.getModel(), perfPoints, profit));
            }
        }

        return sb.toString();
    }
}
