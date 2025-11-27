import java.util.List;
import java.util.ArrayList;

// ----- Strategy Interface -----
interface VatStrategy {
    double applyVat(double amount);
}

// ----- Strategy Implementations -----
class ReducedVat implements VatStrategy {
    public double applyVat(double amount) {
        return amount * 1.13;
    }
}

class NormalVat implements VatStrategy {
    public double applyVat(double amount) {
        return amount * 1.24;
    }
}

class ExtraVat implements VatStrategy {
    public double applyVat(double amount) {
        return amount * 1.33;
    }
}

// ----- Enum for VAT Type -----
enum VatType {
    REDUCED(new ReducedVat()),
    NORMAL(new NormalVat()),
    EXTRA(new ExtraVat());

    private final VatStrategy strategy;

    VatType(VatStrategy strategy) {
        this.strategy = strategy;
    }

    public VatStrategy getStrategy() {
        return strategy;
    }
}

// ----- Item Class (Dummy Implementation) -----
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// ----- Warehouse Class -----
public class Warehouse {
    private String name;
    private List<Item> items;    // available items (stock)
    private List<Item> orders;   // ordered items (removed from stock)
    private String type;         // local or central
    private VatStrategy vatStrategy;

    public Warehouse(String name, List<Item> items, String type, VatType vatType) {
        this.name = name;
        this.items = items;
        this.orders = new ArrayList<>();
        this.type = type;
        this.vatStrategy = vatType.getStrategy();
    }

    public void addOrder(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            orders.add(item);
        }
    }

    public double calcCost() {
        double total = 0.0;
        for (Item item : orders) {
            total += item.getPrice();
        }
        return vatStrategy.applyVat(total);
    }
}