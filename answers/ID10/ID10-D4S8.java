
// Refactored version using Open/Closed Principle and Composite Pattern

import java.util.ArrayList;
import java.util.List;

// Abstract class Product
abstract class Product {
    public abstract String getName();
}

// Subclasses of Product
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

// Store class that manages all products in a single list
class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product item) {
        this.products.add(item);
    }

    public int getTotalItems() {
        return products.size();
    }

    public void printItemNames() {
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
}
