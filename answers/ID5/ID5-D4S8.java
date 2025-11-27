import java.util.ArrayList;
import java.util.List;

// Abstract Product class
abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete product classes
class Vegetable extends Product {
    public Vegetable(String name) {
        super(name);
    }
}

class Fruit extends Product {
    public Fruit(String name) {
        super(name);
    }
}

class Dairy extends Product {
    public Dairy(String name) {
        super(name);
    }
}

// Store class
class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product item) {
        products.add(item);
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
