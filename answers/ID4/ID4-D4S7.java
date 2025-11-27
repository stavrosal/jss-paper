import java.util.ArrayList;
import java.util.List;

// Αφηρημένη κλάση Product
abstract class Product {
    public abstract String getName();
}

// Υλοποιήσεις προϊόντων
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

// Store ως Composite
class Store {
    private List<Product> products = new ArrayList<>();

    // Προσθήκη οποιουδήποτε προϊόντος
    public void addProduct(Product product) {
        products.add(product);
    }

    // Σύνολο όλων των προϊόντων
    public int getTotalItems() {
        return products.size();
    }

    // Εκτύπωση ονομάτων προϊόντων
    public void printItemNames() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}