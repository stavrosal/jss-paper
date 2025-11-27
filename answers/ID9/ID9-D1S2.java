import java.util.*;

// ===== Abstract Products =====

abstract class Clothes {
    public abstract void printInfo();
}

abstract class Shirt extends Clothes {
    // Inherits printInfo from Clothes
}

abstract class Pants extends Clothes {
    // Inherits printInfo from Clothes
}

// ===== Concrete Products =====

class VintageShirt extends Shirt {
    public void printInfo() {
        System.out.println("A vintage shirt");
    }
}

class VintagePants extends Pants {
    public void printInfo() {
        System.out.println("A vintage pair of pants");
    }
}

class ModernShirt extends Shirt {
    public void printInfo() {
        System.out.println("A modern shirt");
    }
}

class ModernPants extends Pants {
    public void printInfo() {
        System.out.println("A modern pair of pants");
    }
}

// ===== Abstract Factory =====

interface ClothesFactory {
    Shirt createShirt();
    Pants createPants();
}

// ===== Concrete Factories =====

class VintageClothesFactory implements ClothesFactory {
    public Shirt createShirt() {
        return new VintageShirt();
    }

    public Pants createPants() {
        return new VintagePants();
    }
}

class ModernClothesFactory implements ClothesFactory {
    public Shirt createShirt() {
        return new ModernShirt();
    }

    public Pants createPants() {
        return new ModernPants();
    }
}

// ===== Shop Class =====

class Shop {
    private List<Clothes> clothing;
    private ClothesFactory factory;

    public Shop(ClothesFactory factory) {
        this.clothing = new ArrayList<>();
        this.factory = factory;
    }

    public void addShirt() {
        clothing.add(factory.createShirt());
    }

    public void addPants() {
        clothing.add(factory.createPants());
    }

    public void printAllClothes() {
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

// ===== Main Class =====

public class MainClass {
    public static void main(String[] args) {
        Shop vintageShop = new Shop(new VintageClothesFactory());
        vintageShop.addShirt();
        vintageShop.addPants();
        vintageShop.printAllClothes();

        System.out.println();

        Shop modernShop = new Shop(new ModernClothesFactory());
        modernShop.addShirt();
        modernShop.addPants();
        modernShop.printAllClothes();
    }
}