public class Worker extends Human {

    private static final String INVALID_SALARY_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    private static final String INVALID_LAST_NAME_EXCEPTION_MESSAGE = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WORKING_HOURS_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";

    private double salary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double salary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary < 10) {
            throw new IllegalArgumentException(INVALID_SALARY_EXCEPTION_MESSAGE);
        }
        this.salary = salary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(INVALID_WORKING_HOURS_EXCEPTION_MESSAGE);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.getSalary() / 7.0 / this.getWorkHoursPerDay();
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_EXCEPTION_MESSAGE);
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.getFirstName()).append(System.lineSeparator());
        sb.append("Last Name: ").append(this.getLastName()).append(System.lineSeparator());
        sb.append("Week Salary: ").append(String.format("%.2f", this.getSalary())).append(System.lineSeparator());
        sb.append("Hours per day: ").append(String.format("%.2f", this.getWorkHoursPerDay())).append(System.lineSeparator());
        sb.append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));

        return sb.toString();
    }
}
