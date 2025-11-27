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

public class Recipe{
	String name;
	String productType;
	
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}
	
	public void prepareIngredients(){
		if (productType.equals("Cake")){
			System.out.println("Preparing ingredients for cake...");
		}
		else if (productType.equals("Bread")){
			System.out.println("Preparing ingredients for bread...");
		}
	}
	
	public void bake(){
		if (productType.equals("Cake")){
			System.out.println("Baking cake...");
		}
		else if (productType.equals("Bread")){
			System.out.println("Baking bread...");
		}
	}
	
	public void serve(){
		if (productType.equals("Cake")){
			System.out.println("Serving cake...");
		}
		else if (productType.equals("Bread")){
			System.out.println("Serving bread...");
		}
	}
}