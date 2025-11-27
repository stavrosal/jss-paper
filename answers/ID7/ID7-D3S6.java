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

public abstract class Recipe{

	public abstract void prepareIngredients();
	public abstract void bake();
	public abstract void serve();
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}

}

public class Cake extends Recipe{

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

public class Bread extends Recipe{

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
