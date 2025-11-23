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
