class Store{
	
	List<Product> products;
	
	public void addProduct(Product p){
		this.products.add(p);
	}
	
	public int getTotalItems(){
		int total = products.size();
		
		return total;
	}
		
	public void printItemNames(){
		// Supposing that all Product classes have a getName() method
		for (Product p : products){
			System.out.println(p.getName());
		}
		
	}
}

interface Product{
	public String getName();
}

class Vegetable implements Product{
	String name;
	
	public Vegetable(name n){
		this.name = n;
	}
	
	public String getName(){
		return this.name();
	}
	
}

class Fruit implements Product{
	String name;
	
	public Fruit(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name();
	}
	
}

class Dairy implements Product{
	String name;
	
	public Dairy(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name();
	}
	
}
