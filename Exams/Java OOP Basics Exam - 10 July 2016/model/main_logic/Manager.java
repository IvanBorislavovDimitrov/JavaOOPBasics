package app.model.main_logic;

import app.model.hardware.Hardware;
import app.model.hardware.HeavyHardware;
import app.model.hardware.PowerHardware;
import app.model.software.ExpressSoftware;
import app.model.software.LightSoftware;
import app.model.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class Manager {

    private Map<String, Hardware> hardware;
    private Map<String, Hardware> dump;

    public Manager() {
        this.hardware = new LinkedHashMap<>();
        this.dump = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        Hardware powerHardware = new PowerHardware(name, capacity, memory);
        this.hardware.put(name, powerHardware);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        Hardware heavyHardware = new HeavyHardware(name, capacity, memory);
        this.hardware.put(name, heavyHardware);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Hardware hardware = this.hardware.get(hardwareComponentName);
        if (hardware == null) {
            return;
        }
        Software expressSoftware = new ExpressSoftware(name, capacity, memory);
        hardware.addSoftware(expressSoftware);
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Hardware hardware = this.hardware.get(hardwareComponentName);
        if (hardware == null) {
            return;
        }
        Software lightSoftware = new LightSoftware(name, capacity, memory);
        hardware.addSoftware(lightSoftware);
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        Hardware hardware = this.hardware.get(hardwareComponentName);
        if (hardware == null) {
            return;
        }

        hardware.removeByName(softwareComponentName);
    }

    public String analyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d", this.hardware.size())).append(System.lineSeparator());
        sb.append(String.format("Software Components: %d", this.hardware.values().stream().mapToInt(h -> h.getSoftwares().size()).sum())).append(System.lineSeparator());
        int totalOperationalMemoryInUse =
                this.hardware.values().stream()
                        .mapToInt(s -> s.getSoftwares().stream().mapToInt(Software::getMemoryConsumption).sum())
                        .sum();
        int maximumMemory =
                this.hardware.values().stream()
                        .mapToInt(Hardware::getMaximumMemory).sum();
        int totalCapacityTaken =
                this.hardware.values().stream()
                        .mapToInt(s -> s.getSoftwares().stream().mapToInt(Software::getCapacityConsumption).sum())
                        .sum();
        int maximumCapacity =
                this.hardware.values().stream()
                        .mapToInt(Hardware::getMaximumCapacity).sum();
        sb.append(String.format("Total Operational Memory: %d / %d", totalOperationalMemoryInUse, maximumMemory))
                .append(System.lineSeparator());
        sb.append(String.format("Total Capacity Taken: %d / %d", totalCapacityTaken, maximumCapacity));

        return sb.toString();
    }

    public String systemSplit() {
        StringBuilder sb = new StringBuilder();
        this.hardware.values().forEach(h -> sb.append(h.toString()).append(System.lineSeparator()));

        return sb.toString();
    }

    public void dump(String hardwareComponentName) {
        Hardware hardware = this.hardware.get(hardwareComponentName);
        if (hardware == null) {
            return;
        }

        this.hardware.remove(hardwareComponentName);
        this.dump.put(hardwareComponentName, hardware);
    }

    public void restore(String hardwareComponentName) {
        Hardware hardware = this.dump.get(hardwareComponentName);
        if (hardware == null) {
            return;
        }
        this.dump.remove(hardwareComponentName);
        this.hardware.put(hardwareComponentName, hardware);
    }

    public void destroy(String hardwareComponentName) {
        this.dump.remove(hardwareComponentName);
    }

    public String dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append(String.format("Power Hardware Components: %d", this.dump.values().stream()
                .filter(h -> h.getType().equals("PowerHardware")).count())).append(System.lineSeparator());

        sb.append(String.format("Heavy Hardware Components: %d", this.dump.values().stream()
                .filter(h -> h.getType().equals("HeavyHardware")).count())).append(System.lineSeparator());

        sb.append(String.format("Express Software Components: %d",
                this.dump.values().stream().mapToInt(h -> (int) h.getSoftwares().stream().filter(s -> s.getType().equals("ExpressSoftware")).count()).sum())).append(System.lineSeparator());

        sb.append(String.format("Light Software Components: %d",
                this.dump.values().stream().mapToInt(h -> (int) h.getSoftwares().stream().filter(s -> s.getType().equals("LightSoftware")).count()).sum())).append(System.lineSeparator());

        sb.append(String.format("Total Dumped Memory: %d",
                this.dump.values().stream().mapToInt(h -> h.getSoftwares().stream()
                        .mapToInt(Software::getMemoryConsumption).sum())
                        .sum())).append(System.lineSeparator());

        sb.append(String.format("Total Dumped Capacity: %d",
                this.dump.values().stream().mapToInt(h -> h.getSoftwares().stream()
                        .mapToInt(Software::getCapacityConsumption).sum())
                        .sum()));

        return sb.toString();
    }
}
