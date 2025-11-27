
// VAT Strategy Interface
interface VatStrategy {
    double applyVat(double basePrice);
}

// Concrete VAT Strategies
class ReducedVat implements VatStrategy {
    public double applyVat(double basePrice) {
        return basePrice * 1.05; // 5% VAT
    }
}

class NormalVat implements VatStrategy {
    public double applyVat(double basePrice) {
        return basePrice * 1.20; // 20% VAT
    }
}

class ExtraVat implements VatStrategy {
    public double applyVat(double basePrice) {
        return basePrice * 1.30; // 30% VAT
    }
}

// Abstract Warehouse
abstract class Warehouse {
    protected String name;
    protected List<Item> items;
    protected List<Item> orders;
    protected VatStrategy vatStrategy;

    public Warehouse(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addOrder(Item item) {
        if (items.remove(item)) {
            orders.add(item);
        }
    }

    public double calcCost() {
        double total = 0.0;
        for (Item item : orders) {
            total += vatStrategy.applyVat(item.getPrice());
        }
        return total;
    }

    public abstract String getWarehouseType();
}

// Local Warehouse
class LocalWarehouse extends Warehouse {
    public LocalWarehouse(String name) {
        super(name);
        this.vatStrategy = new ReducedVat(); // or NormalVat depending on business rule
    }

    @Override
    public String getWarehouseType() {
        return "LOCAL";
    }
}

// Central Warehouse
class CentralWarehouse extends Warehouse {
    public CentralWarehouse(String name) {
        super(name);
        this.vatStrategy = new ExtraVat(); // example rate
    }

    @Override
    public String getWarehouseType() {
        return "CENTRAL";
    }
}

// Example Item Class
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
