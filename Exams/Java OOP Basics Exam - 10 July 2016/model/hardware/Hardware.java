package app.model.hardware;

import app.model.software.Software;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Hardware {

    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwares;

    public Hardware(String name, int maximumCapacity, int maximumMemory) {
        this.setName(name);
        this.setType(this.getClass().getSimpleName());
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwares = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public List<Software> getSoftwares() {
        return Collections.unmodifiableList(this.softwares);
    }

    public boolean addSoftware(Software software) {
        int currentCapacity = this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
        int currentMemory = this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum();

        int newCapacity = currentCapacity + software.getCapacityConsumption();
        int newMemory = currentMemory + software.getMemoryConsumption();

        if (newCapacity <= this.maximumCapacity && newMemory <= this.maximumMemory) {
            this.softwares.add(software);
            return true;
        }

        return false;
    }

    public void removeByName(String softwareName) {
        this.softwares.removeIf(s -> s.getName().equals(softwareName));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hardware Component - %s", this.getName())).append(System.lineSeparator());
        int countOfExpressSoftwareComponents = (int) this.softwares.stream().filter(s -> s.getType().equals("ExpressSoftware")).count();
        sb.append(String.format("Express Software Components - %d", countOfExpressSoftwareComponents)).append(System.lineSeparator());
        int countOfLightSoftwareComponents = (int) this.softwares.stream().filter(s -> s.getType().equals("LightSoftware")).count();
        sb.append(String.format("Light Software Components - %d", countOfLightSoftwareComponents)).append(System.lineSeparator());
        int memoryUsed = this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum();
        int maxMemory = this.getMaximumMemory();
        sb.append(String.format("Memory Usage: %d / %d", memoryUsed, maxMemory)).append(System.lineSeparator());
        int capacityUsed = this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
        int maximumCapacity = this.getMaximumCapacity();
        sb.append(String.format("Capacity Usage: %d / %d", capacityUsed, maximumCapacity)).append(System.lineSeparator());
        sb.append(String.format("Type: %s", this.getType().substring(0, this.getType().indexOf("Hardware"))))
                .append(System.lineSeparator());
        sb.append("Software Components: ");
        sb.append(this.softwares.size() == 0 ? "None" : String.join(", ",
                this.softwares.stream().map(Software::getName).collect(Collectors.toList())));

        return sb.toString();
    }
}


