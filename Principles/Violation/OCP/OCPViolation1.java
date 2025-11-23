class Store{

	List<Vegetable> vegetables;
	List<Fruit> fruits;
	List<Dairy> dairy;
	
	public void addVegetable(Vegetable item){
		this.vegetables.add(item);
	}
	
	public void addFruit(Fruit item){
		this.fruits.add(item);
	}
	
	public void addDairy(Dairy item){
		this.dairy.add(item);
	}
	
	public int getTotalItems(){
		int total = vegetables.size() + fruits.size() + dairy.size();
		
		return total;
	}
	
	
	public void printItemNames(){
		// Supposing that all Product classes have a getName() method
		for (Vegetable v : vegetables){
			System.out.println(v.getName());
		}
		
		for (Fruit f : fruits){
			System.out.println(f.getName());
		}
		
		for (Dairy d : dairy){
			System.out.println(d.getName());
		}
	}
}
