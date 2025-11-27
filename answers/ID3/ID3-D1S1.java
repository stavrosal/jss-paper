import java.util.*;

// Step 1: Define Clothing Style
enum Style {
    VINTAGE, MODERN;
}

// Step 2: Abstract Clothes class
public abstract class Clothes {
    public abstract String getType(); // "shirt", "pants", etc.
    public abstract Style getStyle(); // Modern or Vintage

    public void printInfo() {
        System.out.println("A " + getStyle().toString().toLowerCase() + " " + getType());
    }
}

// Step 3: Concrete clothes (no need to override printInfo)
public class Shirt extends Clothes {
    private Style style;

    public Shirt(Style style) {
        this.style = style;
    }

    public String getType() {
        return "shirt";
    }

    public Style getStyle() {
        return style;
    }
}

public class Pants extends Clothes {
    private Style style;

    public Pants(Style style) {
        this.style = style;
    }

    public String getType() {
        return "pair of pants";
    }

    public Style getStyle() {
        return style;
    }
}

// Step 4: Shop enforces style without knowing specifics
public class Shop {
    private Style shopStyle;
    private List<Clothes> clothing;

    public Shop(Style style) {
        this.shopStyle = style;
        this.clothing = new ArrayList<>();
    }

    public void addClothing(Clothes c) {
        if (c.getStyle() != shopStyle) {
            throw new IllegalArgumentException("This shop only sells " + shopStyle.toString().toLowerCase() + " clothes.");
        }
        clothing.add(c);
    }

    public void printInventory() {
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

// Step 5: Usage
public class MainClass {
    public static void main(String[] args) {
        Shop vintageShop = new Shop(Style.VINTAGE);
        vintageShop.addClothing(new Shirt(Style.VINTAGE));
        vintageShop.addClothing(new Pants(Style.VINTAGE));

        Shop modernShop = new Shop(Style.MODERN);
        modernShop.addClothing(new Shirt(Style.MODERN));
        modernShop.addClothing(new Pants(Style.MODERN));

        System.out.println("Vintage shop inventory:");
        vintageShop.printInventory();

        System.out.println("\nModern shop inventory:");
        modernShop.printInventory();
    }
}
