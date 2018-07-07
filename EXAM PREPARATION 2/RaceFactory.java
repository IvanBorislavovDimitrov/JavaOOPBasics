public final class RaceFactory {

    private static final String CASUAL_RACE = "Casual";
    private static final String DRAG_RACE = "Drag";
    private static final String DRIFT_RACE = "Drift";
    private static final String CIRCUIT_RACE = "Circuit";
    private static final String TIME_LIMIT_RACE = "TimeLimit";

    private RaceFactory() {
    }

    public static Race createRace(String type, int length, String route, int prizePool) {
        switch (type) {
            case CASUAL_RACE:
                return new CasualRace(length, route, prizePool);
            case DRAG_RACE:
                return new DragRace(length, route, prizePool);
            case DRIFT_RACE:
                return new DriftRace(length, route, prizePool);

        }

        return null;
    }

    public static Race createRaceSpecial(String type, int length, String route, int prizePool, int opt) {
        switch (type) {
            case CIRCUIT_RACE:
                return new CircuitRace(length, route, prizePool, opt);
            case TIME_LIMIT_RACE:
                return new TimeLimitRace(length, route, prizePool, opt);
        }

        return null;
    }
}
