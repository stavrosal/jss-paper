
// Refactored version using Factory Method Pattern

interface Clothes {
    void printInfo();
}

class Shirt implements Clothes {
    private final String type;

    public Shirt(String type) {
        this.type = type;
    }

    public void printInfo() {
        System.out.println("A " + type.toLowerCase() + " shirt");
    }
}

class Pants implements Clothes {
    private final String type;

    public Pants(String type) {
        this.type = type;
    }

    public void printInfo() {
        System.out.println("A " + type.toLowerCase() + " pants");
    }
}

// Factory Interface
interface ClothesFactory {
    Clothes createShirt();
    Clothes createPants();
}

// Modern Clothes Factory
class ModernClothesFactory implements ClothesFactory {
    public Clothes createShirt() {
        return new Shirt("Modern");
    }

    public Clothes createPants() {
        return new Pants("Modern");
    }
}

// Vintage Clothes Factory
class VintageClothesFactory implements ClothesFactory {
    public Clothes createShirt() {
        return new Shirt("Vintage");
    }

    public Clothes createPants() {
        return new Pants("Vintage");
    }
}

// Test Class
public class Main {
    public static void main(String[] args) {
        ClothesFactory vintageFactory = new VintageClothesFactory();
        Clothes vintageShirt = vintageFactory.createShirt();
        Clothes vintagePants = vintageFactory.createPants();
        vintageShirt.printInfo();
        vintagePants.printInfo();

        ClothesFactory modernFactory = new ModernClothesFactory();
        Clothes modernShirt = modernFactory.createShirt();
        Clothes modernPants = modernFactory.createPants();
        modernShirt.printInfo();
        modernPants.printInfo();
    }
}
