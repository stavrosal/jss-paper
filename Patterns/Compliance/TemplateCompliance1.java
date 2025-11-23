public abstract class Recipe{
	String name;
	
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}
	
	abstract void prepareIngredients();
	abstract void bake();
	abstract void serve();
}

public class CakeRecipe extends Recipe{
	
	@Override
	public void prepareIngredients(){
		System.out.println("Preparing ingredients for cake...");
	}
	
	@Override
	public void bake(){
		System.out.println("Baking cake...");
	}
	
	@Override
	public void serve(){
		System.out.println("Serving cake...");
	}
		
}

public class BreadRecipe extends Recipe{
	
	@Override
	public void prepareIngredients(){
		System.out.println("Preparing ingredients for bread...");
	}
	
	@Override
	public void bake(){
		System.out.println("Baking bread...");
	}
	
	@Override
	public void serve(){
		System.out.println("Serving bread...");
	}
		
}