class Wedding{
	String venue;
	
	List<Person> people;
	
	public void addPerson(Person p){
		this.people.add(p);
	}
	
	public double calculateFoodCost(){
		int vegans = 0; 
		for (Person p : people){
			if (p.isVegan()){
				vegans += 1;
			}
		}
		
		int non_vegans = people.size() - vegans;
		
		double total; // total cost
		if (people.size() <= 500){
			total = non_vegans * 3 + vegans * 3.5;
		}
		else{
			total = non_vegans * 2 + vegans * 2.5;
		}
		
		return total;	
	}
	
	public double calcPhotosCost(){
		double cost;
		if (people.size() <= 600){
			cost = people.size() * 1;
		}
		else{
			cost = people.size * 0.75;
		}
		
		return cost;
	}
		 

}
