package app.models.imp;

import app.constants.Constants;
import app.models.api.SuperPower;

public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, int powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        String regex = "@[A-Za-z_]{3,}@";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException(Constants.POWER_NAME_NOT_VALID);
        }

        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints < 0) {
            throw new IllegalArgumentException(Constants.POWER_POINTS_NOT_VALID);
        }

        this.powerPoints = powerPoints;
    }

    public String getName() {
        return this.name;
    }

    public double getPowerPoints() {
        return this.powerPoints + this.name.length() / 2;
    }
}
