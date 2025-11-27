interface Employee{
	String name;
	String notes;
	String position;
	String status; //eidanika enum
	
	int weeklyHours;
	int age;
	
	double wage;
	
	public void setWeeklyHours(int hours);
	
	public void addNotes(String note);
	
	public String jobStatus();
	
	public double calcEmployeeSalary();
	
	public double calculateEmployerContribution();
	
	public double calculateTax();
}	


class Junior{
	@Override
	public void setWeeklyHours(int hours){
		this.weeklyHours = hours;
		
		if (weeklyHours < 40){
			this.status = "part-time";
		}
		else{
			this.status "full-time";
		}
	}
	
	@Override
	public String jobStatus{
		return status;
	}
	
	@Override
	public void addNotes(String n){
		this.notes = n;
	}
	
	@Override
	public double calcEmployeeSalary(){
		wage = 8 * weeklyHours * 4
		return wage;
	}
	
	@Override
	public double calculateEmployerContribution(){
		return wage*0.32;
	}
	
	@Override
	public double calculateTax(){
		return wage*0.04;
	}
}

class midLevel{
	@Override
	public void setWeeklyHours(int hours){
		this.weeklyHours = hours;
		
		if (weeklyHours < 40){
			this.status = "part-time";
		}
		else{
			this.status "full-time";
		}
	}
	
	@Override
	public String jobStatus{
		return status;
	}
	
	@Override
	public void addNotes(String n){
		this.notes = n;
	}
	
	@Override
	public double calcEmployeeSalary(){
		wage = 10 * weeklyHours * 4
		return wage;
	}
	
	@Override
	public double calculateEmployerContribution(){
		return wage*0.32;
	}
	
	@Override
	public double calculateTax(){
		return wage*0.04;
	}
}

class midLevel{
	@Override
	public void setWeeklyHours(int hours){
		this.weeklyHours = hours;
		
		if (weeklyHours < 40){
			this.status = "part-time";
		}
		else{
			this.status "full-time";
		}
	}
	
	@Override
	public String jobStatus{
		return status;
	}
	
	@Override
	public void addNotes(String n){
		this.notes = n;
	}
	
	@Override
	public double calcEmployeeSalary(){
		wage = 12 * weeklyHours * 4
		return wage;
	}
	
	@Override
	public double calculateEmployerContribution(){
		return wage*0.32;
	}
	
	@Override
	public double calculateTax(){
		return wage*0.04;
	}
}