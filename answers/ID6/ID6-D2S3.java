import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a warehouse managing items and orders with VAT-based cost calculation.
 */
public class Warehouse {
    private final String name;
    private final List<Item> items; // Available items (stock)
    private final List<Item> orders; // Ordered items
    private final String type; // e.g., LOCAL, CENTRAL
    private final VATStrategy vatStrategy;

    /**
     * Strategy interface for VAT rate calculation.
     */
    public interface VATStrategy {
        double getRate();
    }

    /**
     * Reduced VAT rate (13%).
     */
    public static class ReducedVAT implements VATStrategy {
        @Override
        public double getRate() { return 0.13; }
    }

    /**
     * Normal VAT rate (24%).
     */
    public static class NormalVAT implements VATStrategy {
        @Override
        public double getRate() { return 0.24; }
    }

    /**
     * Extra VAT rate (33%).
     */
    public static class ExtraVAT implements VATStrategy {
        @Override
        public double getRate() { return 0.33; }
    }

    /**
     * Creates a warehouse with the specified attributes.
     * @param name Warehouse name
     * @param items Initial stock
     * @param type Warehouse type (e.g., LOCAL, CENTRAL)
     * @param vatStrategy VAT calculation strategy
     */
    public Warehouse(String name, List<Item> items, String type, VATStrategy vatStrategy) {
        this.name = name != null ? name : "";
        this.items = new ArrayList<>(items != null ? items : Collections.emptyList());
        this.orders = new ArrayList<>();
        this.type = type != null ? type : "";
        this.vatStrategy = vatStrategy != null ? vatStrategy : new NormalVAT();
    }

    /**
     * Adds an item to orders and removes it from stock.
     * @param item Item to order
     * @throws IllegalArgumentException if item is null or not in stock
     */
    public void addOrder(Item item) {
        if (item == null || !items.contains(item)) {
            throw new IllegalArgumentException("Item not in stock or null");
        }
        items.remove(item);
        orders.add(item);
    }

    /**
     * Calculates total cost of orders with VAT.
     * @return Total cost including VAT
     */
    public double calcCost() {
        double cost = 0.0;
        for (Item item : orders) {
            cost += item.getPrice();
        }
        return cost * (1 + vatStrategy.getRate());
    }

    /**
     * Interface for items with a price.
     */
    public interface Item {
        double getPrice();
    }
}