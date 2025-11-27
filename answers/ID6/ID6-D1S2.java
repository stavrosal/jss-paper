// !!!FACTORY METHOD!!!
public enum Style { VINTAGE, MODERN }
public enum Category { SHIRT, PANTS }

public class Clothes {
    private Style style;
    private Category category;

    public Clothes(Style style, Category category) {
        this.style = style;
        this.category = category;
    }

    public void printInfo() {
        System.out.println("A " + style.toString().toLowerCase() + " " + category.toString().toLowerCase());
    }

    public Style getStyle() { return style; }
    public Category getCategory() { return category; }
}

public interface ClothingFactory {
    Clothes createClothing(Style style, Category category);
}

public class SimpleClothingFactory implements ClothingFactory {
    @Override
    public Clothes createClothing(Style style, Category category) {
        return new Clothes(style, category);
    }
}

public class Shop {
    private java.util.List<Clothes> clothing;
    private Style shopType;

    public Shop(Style shopType) {
        this.clothing = new java.util.ArrayList<>();
        this.shopType = shopType;
    }

    public void addClothing(Clothes c) {
        if (c.getStyle() == shopType) {
            clothing.add(c);
        } else {
            throw new IllegalArgumentException("Invalid clothing style for this shop");
        }
    }

    public void printInventory() {
        System.out.println("Inventory of " + shopType + " shop:");
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        ClothingFactory factory = new SimpleClothingFactory();

        Shop vintageShop = new Shop(Style.VINTAGE);
        vintageShop.addClothing(factory.createClothing(Style.VINTAGE, Category.SHIRT));
        vintageShop.addClothing(factory.createClothing(Style.VINTAGE, Category.PANTS));
        vintageShop.printInventory();

        Shop modernShop = new Shop(Style.MODERN);
        modernShop.addClothing(factory.createClothing(Style.MODERN, Category.SHIRT));
        modernShop.addClothing(factory.createClothing(Style.MODERN, Category.PANTS));
        modernShop.printInventory();
    }
}

// !!!OCP!!!
public enum Style { VINTAGE, MODERN }
public enum Category { SHIRT, PANTS }

public class Clothes {
    private Style style;
    private Category category;

    public Clothes(Style style, Category category) {
        this.style = style;
        this.category = category;
    }

    public void printInfo() {
        System.out.println("A " + style.toString().toLowerCase() + " " + category.toString().toLowerCase());
    }

    public Style getStyle() { return style; }
    public Category getCategory() { return category; }
}

public class Shop {
    private java.util.List<Clothes> clothing;
    private Style shopType;

    public Shop(Style shopType) {
        this.clothing = new java.util.ArrayList<>();
        this.shopType = shopType;
    }

    public void addClothing(Clothes c) {
        if (c.getStyle() == shopType) {
            clothing.add(c);
        } else {
            throw new IllegalArgumentException("Invalid clothing style for this shop");
        }
    }

    public void printInventory() {
        System.out.println("Inventory of " + shopType + " shop:");
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Shop vintageShop = new Shop(Style.VINTAGE);
        vintageShop.addClothing(new Clothes(Style.VINTAGE, Category.SHIRT));
        vintageShop.addClothing(new Clothes(Style.VINTAGE, Category.PANTS));
        vintageShop.printInventory();

        Shop modernShop = new Shop(Style.MODERN);
        modernShop.addClothing(new Clothes(Style.MODERN, Category.SHIRT));
        modernShop.addClothing(new Clothes(Style.MODERN, Category.PANTS));
        modernShop.printInventory();
    }
}