import java.util.*;

// === Abstract Layer ===

public abstract class Clothes {
    public abstract void printInfo();
}

public abstract class Shirt extends Clothes {}
public abstract class Pants extends Clothes {}


// === Concrete Implementations ===

public class VintageShirt extends Shirt {
    public void printInfo() {
        System.out.println("A vintage shirt");
    }
}

public class ModernShirt extends Shirt {
    public void printInfo() {
        System.out.println("A modern shirt");
    }
}

public class VintagePants extends Pants {
    public void printInfo() {
        System.out.println("A vintage pair of pants");
    }
}

public class ModernPants extends Pants {
    public void printInfo() {
        System.out.println("A modern pair of pants");
    }
}


// === Abstract Factory ===

public interface ClothesFactory {
    Shirt createShirt();
    Pants createPants();
}


// === Concrete Factories ===

public class VintageClothesFactory implements ClothesFactory {
    public Shirt createShirt() {
        return new VintageShirt();
    }

    public Pants createPants() {
        return new VintagePants();
    }
}

public class ModernClothesFactory implements ClothesFactory {
    public Shirt createShirt() {
        return new ModernShirt();
    }

    public Pants createPants() {
        return new ModernPants();
    }
}


// === Generic Shop Class ===

public class Shop<T extends Clothes> {
    private List<T> items;

    public Shop() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void printAllItems() {
        for (T item : items) {
            item.printInfo();
        }
    }
}


// === Main ===

public class MainClass {
    public static void main(String[] args) {
        ClothesFactory vintageFactory = new VintageClothesFactory();
        Shop<Clothes> vintageShop = new Shop<>();
        vintageShop.addItem(vintageFactory.createShirt());
        vintageShop.addItem(vintageFactory.createPants());

        System.out.println("Vintage Shop:");
        vintageShop.printAllItems();

        ClothesFactory modernFactory = new ModernClothesFactory();
        Shop<Clothes> modernShop = new Shop<>();
        modernShop.addItem(modernFactory.createShirt());
        modernShop.addItem(modernFactory.createPants());

        System.out.println("\nModern Shop:");
        modernShop.printAllItems();
    }
}