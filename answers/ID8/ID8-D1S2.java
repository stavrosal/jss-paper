/*
We wish to model a system of a clothing shop.
The shop (for now) sells only pants and shirts
There are two types of clothing, Vintage and
Modern. Each clothing contains a void printInfo
method which takes no parameters and prints a 
message of the type:
"A <Type> of <Clothes>"
It is worth noting that each clothing shop can 
sell only one of the clothing types, that means
that a Modern Shop cannot sell Vintage clothing
and vice versa.
*/

public enum ClothingStyle {
    VINTAGE, MODERN
}

public enum ClothingType {
    SHIRT, PANTS
}

public class Clothes {
    private final ClothingStyle style;
    private final ClothingType type;

    public Clothes(ClothingStyle style, ClothingType type) {
        this.style = style;
        this.type = type;
    }

    public void printInfo() {
        System.out.printf("A %s %s%n", 
            style.toString().toLowerCase(), 
            type == ClothingType.PANTS ? "pair of pants" : "shirt");
    }

    public ClothingStyle getStyle() {
        return style;
    }

    public ClothingType getType() {
        return type;
    }
}

import java.util.*;

public class Shop {
    private final ClothingStyle shopStyle;
    private final List<Clothes> inventory;

    public Shop(ClothingStyle style) {
        this.shopStyle = style;
        this.inventory = new ArrayList<>();
    }

    public void addClothing(Clothes c) {
        if (c.getStyle() != shopStyle) {
            throw new IllegalArgumentException(
                "This shop only sells " + shopStyle.toString().toLowerCase() + " clothes.");
        }
        inventory.add(c);
    }

    public void printInventory() {
        for (Clothes c : inventory) {
            c.printInfo();
        }
    }

    public ClothingStyle getShopStyle() {
        return shopStyle;
    }
}

public class MainClass {
    public static void main(String[] args) {
        Shop vintageShop = new Shop(ClothingStyle.VINTAGE);
        vintageShop.addClothing(new Clothes(ClothingStyle.VINTAGE, ClothingType.SHIRT));
        vintageShop.addClothing(new Clothes(ClothingStyle.VINTAGE, ClothingType.PANTS));

        System.out.println("Vintage Shop Inventory:");
        vintageShop.printInventory();

        Shop modernShop = new Shop(ClothingStyle.MODERN);
        modernShop.addClothing(new Clothes(ClothingStyle.MODERN, ClothingType.SHIRT));
        modernShop.addClothing(new Clothes(ClothingStyle.MODERN, ClothingType.PANTS));

        System.out.println("\nModern Shop Inventory:");
        modernShop.printInventory();

        // Uncommenting this would throw an exception
        // modernShop.addClothing(new Clothes(ClothingStyle.VINTAGE, ClothingType.PANTS));
    }
}