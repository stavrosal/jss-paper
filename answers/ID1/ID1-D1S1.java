// Enum για τον τύπο του ρούχου
enum ClothingType {
    SHIRT, PANTS
}

// Enum για το στυλ του ρούχου
enum ClothingStyle {
    VINTAGE, MODERN
}

// Βασική αφηρημένη κλάση
abstract class Clothes {
    protected ClothingType type;
    protected ClothingStyle style;

    public Clothes(ClothingType type, ClothingStyle style) {
        this.type = type;
        this.style = style;
    }

    public abstract void printInfo();
}

// Συγκεκριμένη υλοποίηση ρούχου
class ClothingItem extends Clothes {

    public ClothingItem(ClothingType type, ClothingStyle style) {
        super(type, style);
    }

    @Override
    public void printInfo() {
        System.out.println("A " + style.toString().toLowerCase() + " " + type.toString().toLowerCase());
    }
}

// Εργοστάσιο δημιουργίας ρούχων
class ClothingFactory {
    public static Clothes createClothing(ClothingType type, ClothingStyle style) {
        return new ClothingItem(type, style);
    }
}

// Κύρια κλάση με παραδείγματα
public class Main {
    public static void main(String[] args) {
        Clothes shirt1 = ClothingFactory.createClothing(ClothingType.SHIRT, ClothingStyle.VINTAGE);
        Clothes pants1 = ClothingFactory.createClothing(ClothingType.PANTS, ClothingStyle.MODERN);

        shirt1.printInfo(); // A vintage shirt
        pants1.printInfo(); // A modern pants
    }
}
