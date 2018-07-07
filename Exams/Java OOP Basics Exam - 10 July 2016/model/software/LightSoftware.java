package app.model.software;

public class LightSoftware extends Software {

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        int cons = capacityConsumption;
        cons = cons + (cons / 2);

        super.setCapacityConsumption(cons);
    }


    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        int cons = memoryConsumption;
        cons = cons - (cons / 2);

        super.setMemoryConsumption(cons);
    }
}
