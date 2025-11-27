abstract class Recipe{
	public String name;
	public String productType;

	public Recipe(String name,String productType){
		this.name=name;
		this.productType=productType;
	}
	
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}
	
public abstract class Proccess (){

	public void prepareIngredients(){
		System.out.println("Preparing ingredients for "+ productType);
	}
	
	public void bake(){
		System.out.println("Baking "+ productType);
	}
		
	
	public void serve(){
		System.out.println("Serving "+ productType);
	
		}
	}