interface BakeStrategy {
    void prepareIngredients();
    void bake();
    void serve();
}

class CakeStrategy implements BakeStrategy {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing ingredients for cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking cake...");
    }

    @Override
    public void serve() {
        System.out.println("Serving cake...");
    }
}

class BreadStrategy implements BakeStrategy {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing ingredients for bread...");
    }

    @Override
    public void bake() {
        System.out.println("Baking bread...");
    }

    @Override
    public void serve() {
        System.out.println("Serving bread...");
    }
}

public class Recipe {
    private String name;
    private BakeStrategy strategy;

    public Recipe(String name, BakeStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void bakeProcess() {
        strategy.prepareIngredients();
        strategy.bake();
        strategy.serve();
    }

    public void setStrategy(BakeStrategy strategy) {
        this.strategy = strategy;
    }
}