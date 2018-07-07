public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public String race(Race race) {
        if (race.getParticipants().isEmpty()) {
            throw new IllegalArgumentException("Cannot start the race with zero participants.");
        }
        Car car = race.getParticipants().get(0);

        int timePerformance = race.getLength() * ((car.getHorsePower() / 100) * car.getAcceleration());
        StringBuilder sb = new StringBuilder();
        sb.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        sb.append(String.format("%s %s - %d s.", car.getBrand(), car.getModel(), timePerformance)).append(System.lineSeparator());
        if (timePerformance <= this.getGoldTime()) {
            sb.append(String.format("Gold Time, $%d.", race.getPrizePool()));
        } else if (timePerformance <= this.goldTime + 15) {
            sb.append(String.format("Silver Time, $%d.", race.getPrizePool() * 50 / 100));
        } else {
            sb.append(String.format("Bronze Time, $%d.", race.getPrizePool() * 30 / 100));
        }

        return sb.toString();
    }

    public int getGoldTime() {
        return this.goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }
}
