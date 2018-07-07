import java.util.ArrayList;
import java.util.List;

//Never write this code, it was for fun
public class Executor {

    private List<Bender> benders;
    private List<Monument> monuments;
    private List<String> wars;

    public Executor() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
        this.wars = new ArrayList<>();
    }

    public String printWars() {
        StringBuilder sb = new StringBuilder();
        this.wars.forEach(s -> sb.append(s).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    public void createBender(String type, String name, int power, double secondaryParameter) {
        switch (type) {
            case "Air":
                this.benders.add(new AirBender(name, power, secondaryParameter));
                break;
            case "Water":
                this.benders.add(new WaterBender(name, power, secondaryParameter));
                break;
            case "Fire":
                this.benders.add(new FireBender(name, power, secondaryParameter));
                break;
            case "Earth":
                this.benders.add(new EarthBender(name, power, secondaryParameter));
                break;
        }
    }

    public void createMonument(String type, String name, int affinity) {
        switch (type) {
            case "Air":
                this.monuments.add(new AirMonument(name, affinity));
                break;
            case "Water":
                this.monuments.add(new WaterMonument(name, affinity));
                break;
            case "Fire":
                this.monuments.add(new FireMonument(name, affinity));
                break;
            case "Earth":
                this.monuments.add(new EarthMonument(name, affinity));
                break;
        }
    }

    public String status(String nation) {
        StringBuilder sb = new StringBuilder();
        class Ref {
            boolean prop;
        }
        Ref ref = new Ref();
        sb.append(nation).append(" ").append("Nation").append(System.lineSeparator());
        sb.append("Benders: ");
        switch (nation) {
            case "Air":
                this.benders.stream()
                        .filter(b -> b instanceof AirBender)
                        .forEach(b -> {
                            sb.append(System.lineSeparator()).append("###" + b.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None");
                }
                ref.prop = false;
                sb.append(System.lineSeparator());

                sb.append("Monuments: ");
                this.monuments.stream()
                        .filter(m -> m instanceof AirMonument)
                        .forEach(m -> {
                            sb.append(System.lineSeparator()).append("###" + m.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None").append(System.lineSeparator());
                }
                break;
            case "Water":
                this.benders.stream()
                        .filter(b -> b instanceof WaterBender)
                        .forEach(b -> {
                            sb.append(System.lineSeparator()).append("###" + b.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None");
                }
                ref.prop = false;
                sb.append(System.lineSeparator());

                sb.append("Monuments: ");
                this.monuments.stream()
                        .filter(m -> m instanceof WaterMonument)
                        .forEach(m -> {
                            sb.append(System.lineSeparator()).append("###" + m.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None").append(System.lineSeparator());
                }
                break;
            case "Fire":
                this.benders.stream()
                        .filter(b -> b instanceof FireBender)
                        .forEach(b -> {
                            sb.append(System.lineSeparator()).append("###" + b.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None");
                }
                ref.prop = false;
                sb.append(System.lineSeparator());

                sb.append("Monuments: ");
                this.monuments.stream()
                        .filter(m -> m instanceof FireMonument)
                        .forEach(m -> {
                            sb.append(System.lineSeparator()).append("###" + m.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None").append(System.lineSeparator());
                }
                break;
            case "Earth":
                this.benders.stream()
                        .filter(b -> b instanceof EarthBender)
                        .forEach(b -> {
                            sb.append(System.lineSeparator()).append("###" + b.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None");
                }
                sb.append(System.lineSeparator());
                ref.prop = false;
                sb.append("Monuments: ");
                this.monuments.stream()
                        .filter(m -> m instanceof EarthMonument)
                        .forEach(m -> {
                            sb.append(System.lineSeparator()).append("###" + m.toString());
                            ref.prop = true;
                        });
                if (!ref.prop) {
                    sb.append("None").append(System.lineSeparator());
                }
                break;
        }

        return sb.toString().trim();
    }

    public void war(String offender) {
        double airPower = this.benders.stream()
                .filter(b -> b instanceof AirBender)
                .mapToDouble(Bender::getTotalPower)
                .sum() * (this.monuments.stream()
                .filter(m -> m instanceof AirMonument)
                .mapToInt(m -> ((AirMonument) m).getAirAffinity())
                .sum() == 0 ? 1 : (this.monuments.stream()
                .filter(m -> m instanceof AirMonument)
                .mapToInt(m -> ((AirMonument) m).getAirAffinity())
                .sum() / 100.0));

        double earthPower = this.benders.stream()
                .filter(b -> b instanceof EarthBender)
                .mapToDouble(Bender::getTotalPower)
                .sum() * (this.monuments.stream()
                .filter(m -> m instanceof EarthMonument)
                .mapToInt(m -> ((EarthMonument) m).getEarthAffinity())
                .sum() == 0 ? 1 : (this.monuments.stream()
                .filter(m -> m instanceof EarthMonument)
                .mapToInt(m -> ((EarthMonument) m).getEarthAffinity())
                .sum() / 100.0));


        double firePower = this.benders.stream()
                .filter(b -> b instanceof FireBender)
                .mapToDouble(Bender::getTotalPower)
                .sum() * (this.monuments.stream()
                .filter(m -> m instanceof FireMonument)
                .mapToInt(m -> ((FireMonument) m).getFireAffinity())
                .sum() == 0 ? 1 : (this.monuments.stream()
                .filter(m -> m instanceof FireMonument)
                .mapToInt(m -> ((FireMonument) m).getFireAffinity())
                .sum() / 100.0));

        double waterPower = this.benders.stream()
                .filter(b -> b instanceof WaterBender)
                .mapToDouble(Bender::getTotalPower)
                .sum() * (this.monuments.stream()
                .filter(m -> m instanceof WaterMonument)
                .mapToInt(m -> ((WaterMonument) m).getWaterAffinity())
                .sum() == 0 ? 1 : (this.monuments.stream()
                .filter(m -> m instanceof WaterMonument)
                .mapToInt(m -> ((WaterMonument) m).getWaterAffinity())
                .sum() / 100.0));

        if (airPower > earthPower && airPower > firePower && airPower > waterPower) {
            this.benders.removeIf(b -> !(b instanceof AirBender));
            this.monuments.removeIf(b -> !(b instanceof AirMonument));
        } else if (earthPower > airPower && earthPower > firePower && earthPower > waterPower) {
            this.benders.removeIf(b -> !(b instanceof EarthBender));
            this.monuments.removeIf(b -> !(b instanceof EarthMonument));
        } else if (firePower > airPower && firePower > earthPower && firePower > waterPower) {
            this.benders.removeIf(b -> !(b instanceof FireBender));
            this.monuments.removeIf(b -> !(b instanceof FireMonument));
        } else if (waterPower > airPower && waterPower > earthPower && waterPower > firePower) {
            this.benders.removeIf(b -> !(b instanceof WaterBender));
            this.monuments.removeIf(b -> !(b instanceof WaterMonument));
        }

        this.wars.add(String.format("War %d issued by %s", this.wars.size() + 1, offender));

    }
}

