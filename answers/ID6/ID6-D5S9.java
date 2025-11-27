public class PayrollCalculator {
    private static final int WEEKS_PER_MONTH = 4;
    private static final double EMPLOYER_CONTRIBUTION_RATE = 0.32;
    private static final double TAX_RATE = 0.04;

    public double calcEmployeeSalary(Employee employee) {
        double salary = employee.getIndex() * employee.getWeeklyHours() * WEEKS_PER_MONTH;
        employee.setWage(salary);
        return salary;
    }

    public double calculateEmployerContribution(Employee employee) {
        return employee.getWage() * EMPLOYER_CONTRIBUTION_RATE;
    }

    public double calculateTax(Employee employee) {
        return employee.getWage() * TAX_RATE;
    }
}

public abstract class Employee {
    private String name;
    private String notes;
    private int weeklyHours;
    private int age;
    private double wage;
    private final PayrollCalculator payrollCalculator;

    public void setWeeklyHours(int hours) {
        this.weeklyHours = hours;
    }

    public void addNotes(String note) {
        this.notes =  + note;
    }

    public String jobStatus() {
        return weeklyHours < 40 ? "part-time" : "full-time";
    }
    public abstract double getIndex();

    protected void setWage(double wage) {
        this.wage = wage;
    }

    protected int getWeeklyHours() {
        return weeklyHours;
    }

    protected double getWage() {
        return wage;
    }
}

public class JuniorEmployee extends Employee {
    private static final double WAGE_INDEX = 8.0;

    public JuniorEmployee(String name, int age) {
        super(name, age);
    }

    @Override
    public double getIndex() {
        return WAGE_INDEX;
    }
}

public class MidLevelEmployee extends Employee {
    private static final double WAGE_INDEX = 10.0;

    @Override
    public double getIndex() {
        return WAGE_INDEX;
    }
}

public class SeniorEmployee extends Employee {
    private static final double WAGE_INDEX = 12.0;

    @Override
    public double getIndex() {
        return WAGE_INDEX;
    }
}