
import java.util.ArrayList;
import java.util.List;


public interface VATStrategy {
    double getRate();
}

public class ReducedVAT implements VATStrategy {
    public double getRate() { return 0.13; }
}

public class NormalVAT implements VATStrategy {
    public double getRate() { return 0.24; }
}

public class ExtraVAT implements VATStrategy {
    public double getRate() { return 0.33; }
}


public class Warehouse {
    private String name;
    private List<Item> items;   // Stock
    private List<Item> orders;  // Ordered items
    private String type;
    private VATStrategy vatStrategy;

    public Warehouse(String name, List<Item> items, String type, VATStrategy vatStrategy) {
        this.name = name;
        this.items = new ArrayList<>(items);
        this.orders = new ArrayList<>();
        this.type = type;
        this.vatStrategy = vatStrategy;
    }

    public void addOrder(Item item) {
        if (items.remove(item)) {
            orders.add(item);
        } else {
            throw new IllegalArgumentException("Item not found in stock: " + item);
        }
    }

    public double calcCost() {
        double baseCost = 0.0;
        for (Item item : orders) {
            baseCost += item.getPrice();
        }
        return baseCost * (1 + vatStrategy.getRate());
    }

    // Optional: getter for testing
    public List<Item> getOrders() {
        return new ArrayList<>(orders);
    }
}

public class WarehouseFactory {
    public static Warehouse createWarehouse(String name, List<Item> items, String type, String vatType) {
        VATStrategy vatStrategy;

        switch (vatType.toUpperCase()) {
            case "REDUCED":
                vatStrategy = new ReducedVAT();
                break;
            case "NORMAL":
                vatStrategy = new NormalVAT();
                break;
            case "EXTRA":
                vatStrategy = new ExtraVAT();
                break;
            default:
                throw new IllegalArgumentException("Invalid VAT type: " + vatType);
        }

        return new Warehouse(name, items, type, vatStrategy);
    }
}
