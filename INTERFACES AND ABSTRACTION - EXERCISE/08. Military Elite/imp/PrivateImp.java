package imp;

import interfaces.Private;

public class PrivateImp extends SoldierImp implements Private {

    private double salary;

    public PrivateImp(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.getSalary());
    }
}
