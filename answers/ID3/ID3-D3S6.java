public class Recipe{
	String name;
	String productType;
	
	public void bakeProcess(){
		prepareIngredients(type);
		bake(type);
		serve(type);
	}


	
	public void prepareIngredients(String type){
		System.out.println("Preparing Ingredients for" + type);
	}
	
	public void bake(String type){
		System.out.println("Baking" + type + "...");
		
	}
	
	public void serve(String type){
		System.out.println("Serving" + type + "...");
	}
}