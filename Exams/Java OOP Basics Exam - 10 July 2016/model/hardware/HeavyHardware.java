package app.model.hardware;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory;
        memory = memory - (memory / 4);

        super.setMaximumMemory(memory);
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        int capacity = maximumCapacity;
        capacity *= 2;

        super.setMaximumCapacity(capacity);
    }
}
