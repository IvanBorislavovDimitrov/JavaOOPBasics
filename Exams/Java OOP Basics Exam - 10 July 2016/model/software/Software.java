package app.model.software;

import app.model.hardware.Hardware;

public abstract class Software {

    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, int capacityConsumption, int memoryConsumption) {
        this.setName(name);
        this.setType(this.getClass().getSimpleName());
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
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

    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
