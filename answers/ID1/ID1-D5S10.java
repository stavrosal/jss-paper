class Employee{
	String name;
	String notes;
	String position;
	
	int weeklyHours;
	int age;
	
	
	public void setWeeklyHours(int hours){
		this.weeklyHours = hours;
	}
	
	public void addNotes(String note){
		this.notes = note;
	}
	
	public String jobStatus(){
		if (weeklyHours < 40){
			return "part-time";
		}
		else{
			return "full-time";
		}
	}
	
	public abstract double calcEmployeeSalary()
	
	public double calculateEmployerContribution(){
		return wage*0.32;
	}
	
	public double calculateTax(){
		return wage*0.04;
	}
}

class Junior extends Employee {
    //constructor
    public double calculateMonthlySalary() {
        return weeklyHours * 8 * 4;
    }
}

class MidLevel extends Employee {
    //constructor
    public double calculateMonthlySalary() {
        return weeklyHours * 10 * 4;
    }
}

class Senior extends Employee {
    //constructor    
    public double calculateMonthlySalary() {
        return weeklyHours * 12 * 4;
    }
}
