public class Employee {
    private String name;
    private String notes;
    private int weeklyHours;
    private int age;
    Private int position;

    public Employee(String name, int weeklyHours, int age,WageCalculationStrategy strategy) {
        this.name = name;
        this.weeklyHours = weeklyHours;
        this.age = age;
        this.wageStrategy = strategy;
        This.age=age;
    }

	public String jobStatus(){
		if (this.weeklyHours < 40){
			return "part-time";
		}
		else{
			return "full-time";
		}
	}


public double calcEmployeeSalary(){
		if (this.position.equals("junior")){
			return (8 * weeklyHours * 4);
		}
		else if (this.position.equals("mid-level")){
			return (10 * weeklyHours * 4);
		}
		else { 
			return (12 * weeklyHours * 4);
		}

		public double calculateEmployerContribution(){
		return wage*0.32;
		}
	
	public double calculateTax(){
		return wage*0.04;
		}

	}


Public double calcWage(String position){
	
	





}
