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
