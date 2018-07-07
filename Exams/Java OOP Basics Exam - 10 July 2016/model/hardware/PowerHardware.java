package app.model.hardware;

public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        int capacity = maximumCapacity;
        capacity = capacity - ((capacity * 3) / 4);

        super.setMaximumCapacity(capacity);
    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory;
        memory = memory + ((memory * 3) / 4);

        super.setMaximumMemory(memory);
    }
}
