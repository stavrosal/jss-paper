import java.util.ArrayList;
import java.util.List;

// Abstract Product class
abstract class Product {
    public abstract String getName();
}

// Concrete Product types
class Vegetable extends Product {
    private String name;

    public Vegetable(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Fruit extends Product {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Dairy extends Product {
    private String name;

    public Dairy(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Store class using Composite Pattern
class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalItems() {
        return products.size();
    }

    public void printItemNames() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}

// Demo main class
public class E7 {
    public static void main(String[] args) {
        Store store = new Store();

        store.addProduct(new Vegetable("Tomato"));
        store.addProduct(new Fruit("Banana"));
        store.addProduct(new Dairy("Milk"));

        System.out.println("Total items: " + store.getTotalItems());
        store.printItemNames();
    }
}