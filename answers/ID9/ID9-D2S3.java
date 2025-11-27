import java.util.ArrayList;
import java.util.List;

public class WarehouseSystem {

    // ---------- Item class ----------
    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String toString() {
            return name + " (€" + price + ")";
        }
    }

    // ---------- VATType Enum ----------
    public enum VATType {
        REDUCED(0.13),
        NORMAL(0.24),
        EXTRA(0.33);

        private final double rate;

        VATType(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return rate;
        }
    }

    // ---------- VAT Strategy Interface ----------
    public interface VATStrategy {
        double applyVAT(double amount);
    }

    // ---------- VAT Strategy Implementations ----------
    public static class ReducedVAT implements VATStrategy {
        public double applyVAT(double amount) {
            return amount * (1 + VATType.REDUCED.getRate());
        }
    }

    public static class NormalVAT implements VATStrategy {
        public double applyVAT(double amount) {
            return amount * (1 + VATType.NORMAL.getRate());
        }
    }

    public static class ExtraVAT implements VATStrategy {
        public double applyVAT(double amount) {
            return amount * (1 + VATType.EXTRA.getRate());
        }
    }

    // ---------- Abstract Warehouse ----------
    public static abstract class Warehouse {
        private String name;
        private List<Item> items;
        private List<Item> orders;
        private VATStrategy vatStrategy;

        public Warehouse(String name, List<Item> initialItems, VATStrategy vatStrategy) {
            this.name = name;
            this.items = new ArrayList<>(initialItems); // Defensive copy
            this.orders = new ArrayList<>();
            this.vatStrategy = vatStrategy;
        }

        public void addOrder(Item item) {
            if (items.contains(item)) {
                items.remove(item);
                orders.add(item);
            }
        }

        public double calcCost() {
            double cost = 0;
            for (Item i : orders) {
                cost += i.getPrice();
            }
            return vatStrategy.applyVAT(cost);
        }

        public abstract String getType();

        public String getName() {
            return name;
        }

        public List<Item> getStockItems() {
            return new ArrayList<>(items);
        }

        public List<Item> getOrders() {
            return new ArrayList<>(orders);
        }
    }

    // ---------- Local and Central Warehouses ----------
    public static class LocalWarehouse extends Warehouse {
        public LocalWarehouse(String name, List<Item> items, VATStrategy vatStrategy) {
            super(name, items, vatStrategy);
        }

        @Override
        public String getType() {
            return "Local";
        }
    }

    public static class CentralWarehouse extends Warehouse {
        public CentralWarehouse(String name, List<Item> items, VATStrategy vatStrategy) {
            super(name, items, vatStrategy);
        }

        @Override
        public String getType() {
            return "Central";
        }
    }

    // ---------- Warehouse Factory ----------
    public static class WarehouseFactory {
        public static Warehouse createWarehouse(String type, String name, List<Item> items, VATType vatType) {
            VATStrategy vatStrategy = switch (vatType) {
                case REDUCED -> new ReducedVAT();
                case NORMAL -> new NormalVAT();
                case EXTRA -> new ExtraVAT();
            };

            return switch (type.toLowerCase()) {
                case "local" -> new LocalWarehouse(name, items, vatStrategy);
                case "central" -> new CentralWarehouse(name, items, vatStrategy);
                default -> throw new IllegalArgumentException("Invalid warehouse type: " + type);
            };
        }
    }

    // ---------- Main Method (Test) ----------
    public static void main(String[] args) {
        List<Item> stock = new ArrayList<>();
        stock.add(new Item("Chair", 100));
        stock.add(new Item("Table", 150));
        stock.add(new Item("Lamp", 50));

        Warehouse warehouse = WarehouseFactory.createWarehouse("local", "AthensWH", stock, VATType.NORMAL);

        System.out.println("Initial stock: " + warehouse.getStockItems());

        Item itemToOrder = stock.get(0);
        warehouse.addOrder(itemToOrder);

        System.out.println("Stock after order: " + warehouse.getStockItems());
        System.out.println("Ordered items: " + warehouse.getOrders());
        System.out.println("Total cost (with VAT): €" + warehouse.calcCost());
    }
}