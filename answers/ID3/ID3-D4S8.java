import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String name;
    
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

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

class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product item) {
        this.products.add(item);
    }

    public int getTotalItems() {
        return products.size();
    }

    public void printItemNames() {
        for (Product item : products) {
            System.out.println(item.getName());
        }
    }
}
