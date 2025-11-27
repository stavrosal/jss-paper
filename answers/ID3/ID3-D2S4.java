import java.util.List;

public interface VATStrategy {
    double apply(double baseCost);
}

public class ReducedVAT implements VATStrategy {
    @Override
    public double apply(double baseCost) {
        return baseCost * 0.13;
    }
}

public class NormalVAT implements VATStrategy {
    @Override
    public double apply(double baseCost) {
        return baseCost * 0.24;
    }
}

public class ExtraVAT implements VATStrategy {
    @Override
    public double apply(double baseCost) {
        return baseCost * 0.33;
    }
}

public class Warehouse {
    private String name;
    private List<Item> items;
    private List<Item> orders;
    private String type;
    private VATStrategy vatStrategy;

    public Warehouse(String name, List<Item> items, List<Item> orders, String type, VATStrategy vatStrategy) {
        this.name = name;
        this.items = items;
        this.orders = orders;
        this.type = type;
        this.vatStrategy = vatStrategy;
    }

    public void addOrder(Item i) {
        items.remove(i);
        orders.add(i);
    }

    public double calcCost() {
        double baseCost = 0;
        for (Item i : orders) {
            baseCost += i.getPrice();
        }
        return baseCost + vatStrategy.apply(baseCost);
    }
}
