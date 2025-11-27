import java.util.ArrayList;
import java.util.List;

// ---------- ENUMS ----------
enum VATType {
    REDUCED, NORMAL, EXTRA
}

enum WarehouseType {
    LOCAL, CENTRAL
}

// ---------- INTERFACES ----------
interface VATStrategy {
    double applyVAT(double cost);
}

// ---------- STRATEGIES ----------
class ReducedVAT implements VATStrategy {
    public double applyVAT(double cost) {
        return cost * 1.13;
    }
}

class NormalVAT implements VATStrategy {
    public double applyVAT(double cost) {
        return cost * 1.24;
    }
}

class ExtraVAT implements VATStrategy {
    public double applyVAT(double cost) {
        return cost * 1.33;
    }
}

// ---------- ITEM ----------
class Item {
    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Item)) return false;
        Item other = (Item)o;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}

// ---------- WAREHOUSE ----------
public class Warehouse {
    private String name;
    private List<Item> items;
    private List<Item> orders;
    private WarehouseType type;
    private VATStrategy vatStrategy;

    public Warehouse(String name, List<Item> initialItems, WarehouseType type, VATStrategy vatStrategy){
        this.name = name;
        this.items = new ArrayList<>(initialItems); // defensive copy
        this.orders = new ArrayList<>();
        this.type = type;
        this.vatStrategy = vatStrategy;
    }

    public boolean addOrder(Item item){
        if (items.contains(item)) {
            items.remove(item);
            orders.add(item);
            return true;
        }
        return false;
    }

    public double calcCost(){
        double cost = 0;
        for (Item i : orders){
            cost += i.getPrice();
        }
        return vatStrategy.applyVAT(cost);
    }
}
