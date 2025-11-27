public abstract class Recipe{
	public void bakeProcess();
	public void prepareIngredients();
	public void bake();
	public void serve();
}

public class Cake implements Recipe{
	
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}

	public void prepareIngredients(){
		System.out.println("Preparing ingredients for cake...");
	}

	public void bake(){
		System.out.println("Baking cake...");
	}

	public void serve(){
		System.out.println("Serving cake...");
	}
	
}

public class Bread implements Recipe{

	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}

	public void prepareIngredients(){
		System.out.println("Preparing ingredients for bread...");
	}

	public void bake(){
		System.out.println("Baking bread...");
	}

	public void serve(){
		System.out.println("Serving bread...");
	}
}