public abstract class Recipe{
	String name;
	
	public void bakeProcess(){
		prepareIngredients();
		bake();
		serve();
	}
	
	public abstract void prepareIngredients();	
	public abstract void bake();
	public abstract void serve();
}
public class Cake extends Recipe{
    public void prepareIngredients() {
        System.out.println("Preparing ingredients for cake...");
    }

    public void bake() {
       System.out.println("Baking cake...");
    }

    public void serve() {
        System.out.println("Serving cake...");
    }
}

public class Bread extends Recipe{
    public void prepareIngredients() {
        System.out.println("Preparing ingredients for bread...");
    }

    public void bake() {
       System.out.println("Baking bread...");
    }

    public void serve() {
        System.out.println("Serving bread...");
    }
}