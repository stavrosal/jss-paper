import java.util.ArrayList;
import java.util.List;

// Common interface
public interface Product {
    String getName();
}

// Product classes
public class Vegetable implements Product {
    private String name;

    public Vegetable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Fruit implements Product {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Dairy implements Product {
    private String name;

    public Dairy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Store {
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
