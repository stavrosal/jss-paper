import java.util.ArrayList;
import java.util.List;

// Abstract Clothes
public abstract class Clothes {
    public abstract void printInfo();
}

public abstract class Shirt extends Clothes {}
public abstract class Pants extends Clothes {}

// Vintage Clothes
public class VintageShirt extends Shirt {
    public void printInfo() {
        System.out.println("A vintage shirt");
    }
}

public class VintagePants extends Pants {
    public void printInfo() {
        System.out.println("A vintage pair of pants");
    }
}

// Modern Clothes
public class ModernShirt extends Shirt {
    public void printInfo() {
        System.out.println("A modern shirt");
    }
}

public class ModernPants extends Pants {
    public void printInfo() {
        System.out.println("A modern pair of pants");
    }
}

// VintageShop manages only Vintage Clothes
public class VintageShop {
    private List<Clothes> clothing;

    public VintageShop() {
        clothing = new ArrayList<>();
    }

    public void addShirt(VintageShirt shirt) {
        clothing.add(shirt);
    }

    public void addPants(VintagePants pants) {
        clothing.add(pants);
    }

    public void showClothes() {
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

// ModernShop manages only Modern Clothes
public class ModernShop {
    private List<Clothes> clothing;

    public ModernShop() {
        clothing = new ArrayList<>();
    }

    public void addShirt(ModernShirt shirt) {
        clothing.add(shirt);
    }

    public void addPants(ModernPants pants) {
        clothing.add(pants);
    }

    public void showClothes() {
        for (Clothes c : clothing) {
            c.printInfo();
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        VintageShop vintageShop = new VintageShop();
        vintageShop.addShirt(new VintageShirt());
        vintageShop.addPants(new VintagePants());

        ModernShop modernShop = new ModernShop();
        modernShop.addShirt(new ModernShirt());
        modernShop.addPants(new ModernPants());

        vintageShop.showClothes();
        modernShop.showClothes();
    }
}