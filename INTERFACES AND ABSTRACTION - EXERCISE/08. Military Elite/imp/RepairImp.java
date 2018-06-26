package imp;

import interfaces.Repair;

public class RepairImp implements Repair {

    private String partName;
    private int hoursWorked;

    public RepairImp(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.hoursWorked);
    }
}
