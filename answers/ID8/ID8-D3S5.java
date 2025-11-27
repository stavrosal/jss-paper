/*
We want to model a system of Recipes. Each Recipe
contains different type of products. For now, our 
system has two recipes, Cake Recipe and Bread Recipe. 
Each recipe has an ingredients gathering process, a 
baking process and a serving process. The steps are 
the same for all Recipes, but each step can be implemented 
differently, depending on the Recipe's type. Our system's goal 
is to allow each Recipe define their own steps in the process 
without making it too complex.
*/

public enum ProductType {
	Cake,
	Bread,
}

public class Recipe{
	String name;
	ProductType productType;
	
	public Recipe(ProductType productType) {
		this.productType = productType;
	}

	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}
	
	protected void prepareIngredients() {}
	
	protected void bake() {}
	
	protected void serve() {}
}

public class Cake extends Recipe {
	public Cake() {
		super(ProductType.Cake);
	}

	@Override
	protected void prepareIngredients() {
		System.out.println("Preparing ingredients for cake...");
	}

	@Override
	protected void bake() {
		System.out.println("Baking cake...");
	}

	@Override
	protected void serve() {
		System.out.println("Serving cake...");
	}
}

public class Bread extends Recipe {
	public Bread() {
		super(ProductType.Bread);
	}

	@Override
	protected void prepareIngredients() {
		System.out.println("Preparing ingredients for bread...");
	}

	@Override
	protected void bake() {
		System.out.println("Baking bread...");
	}

	@Override
	protected void serve() {
		System.out.println("Serving bread...");
	}
}