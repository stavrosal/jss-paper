/*
A company that has warehouses all over the globe wishes
to develop a system such as each warehouse can manage
its products and calculate order costs. Each warehouse
has some attributes, which are the name of the warehouse (String)
,a List of Items (Item) and a List of Orders (Item). 
There is also a string that will hold the type of the warehouse. 
Each warehouse can be either local or central, based on its location. 
The key difference between a local and a central warehouse is the VAT
rate policy. The vat type (REDUCED, NORMAL, EXTRA) will be held in a String variable.
There is also an addOrder method which takes as a parameter an Item,
adds it to the orders list and at the same time, removes it from the items list. 
Finally, there is a calcCost method which doesn’t take any parameters and calculates
the total cost of the orders, that is, the cost of each item 
(assume there is a getPrice() method in Item class which returns the price of the item as double) 
along with the VAT, which is applied to the total cost. 
*/

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

public enum WarehouseType {
    LOCAL,
    CENTRAL
}

public class Warehouse {
    private String name;
    private List<Item> stock;
    private List<Item> orders;
    private WarehouseType type;
    private VATType vatType;

    public Warehouse(String name, List<Item> stock, WarehouseType type, VATType vatType) {
        this.name = name;
        this.stock = new ArrayList<>(stock);
        this.orders = new ArrayList<>();
        this.type = type;
        this.vatType = vatType;
    }

    public boolean addOrder(Item item) {
        if (stock.remove(item)) {
            orders.add(item);
            return true;
        }
        System.out.println("Item not found in stock: " + item);
        return false;
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Item item : orders) {
            total += item.getPrice();
        }
        return total * (1 + vatType.getRate());
    }
}

