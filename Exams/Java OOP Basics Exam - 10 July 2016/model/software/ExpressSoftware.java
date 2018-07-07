package app.model.software;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        int cons = memoryConsumption;
        cons *= 2;

        super.setMemoryConsumption(cons);
    }
}
