/*
We want to model developers as Employees. Each employee has a name (String),
a notes field (String) and a position in the company (String). Each Employee
also works some pre-specified hours per week (int), has an age (int) and a
wage (double). There are 2 job statuses in the company, part-time if weeklyHours < 40,
and full-time otherwise. Wage is calculated monthly and is dependent on the position
(junior, mid-level, senior) and the total hours worked IN A MONTH. Juniors get 8€/hour,
mid-level get 10€/hour and seniors get 12€/hour. According to tax regulations (which
are specified by the government), there is a 36% wage tax, where the employee contributes
by 4% and the employer by 32%.
*/

class Employee{
	String name;
	String notes;
	String position;
	
	int weeklyHours;
	int age;
	
	double wage;
	
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
	
	public double calcEmployeeSalary(){
		if (position.equals("junior")){
			wage = (8 * weeklyHours * 4);
		}
		else if (position.equals("mid-level")){
			wage =  (10 * weeklyHours * 4);
		}
		else if (position.equals("senior")){ 
			wage = (12 * weeklyHours * 4);
		}
		return wage;
	}
	
	public double calculateEmployerContribution(){
		return wage*0.32;
	}
	
	public double calculateTax(){
		return wage*0.04;
	}
}