import java.util.ArrayList;
import java.util.List;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public abstract String race(Race race);

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
