import java.text.DecimalFormat;

public class Demon extends Base {

    private double specialPoints;

    protected Demon(String username, double specialPoints, int level) {
        super(username, level);
        this.specialPoints = specialPoints;
        this.setHashedPassword();
    }

    public void setHashedPassword() {
        super.setHashedPassword(String.valueOf(this.getUsername().length() * 217));
    }

    public double getSpecialPoints() {
        return this.specialPoints;
    }

    public void setSpecialPoints(double specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("\"%s\" | \"%s\" -> %s\n%s", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName(),
                (this.getSpecialPoints() * this.getLevel()));
    }
}
