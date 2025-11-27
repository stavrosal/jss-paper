import java.util.ArrayList;
import java.util.List;

// Διεπαφή για στρατηγικές υπολογισμού κόστους
interface CostCalculator {
    double calculateCost(Wedding wedding);
}

// Υπολογισμός κόστους φαγητού
class FoodCostCalculator implements CostCalculator {
    @Override
    public double calculateCost(Wedding wedding) {
        int vegans = 0;
        for (Person p : wedding.getPeople()) {
            if (p.isVegan()) vegans++;
        }
        int nonVegans = wedding.getPeople().size() - vegans;

        if (wedding.getPeople().size() <= 500) {
            return nonVegans * 3 + vegans * 3.5;
        } else {
            return nonVegans * 2 + vegans * 2.5;
        }
    }
}

// Υπολογισμός κόστους φωτογραφιών
class PhotoCostCalculator implements CostCalculator {
    @Override
    public double calculateCost(Wedding wedding) {
        int count = wedding.getPeople().size();
        if (count <= 600) {
            return count * 1;
        } else {
            return count * 0.75;
        }
    }
}

// Κλάση Wedding
class Wedding {
    private String venue;
    private List<Person> people = new ArrayList<>();

    public Wedding(String venue) {
        this.venue = venue;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public List<Person> getPeople() {
        return people;
    }

    public double calculateCost(CostCalculator calculator) {
        return calculator.calculateCost(this);
    }
}

// Απλή κλάση Person
class Person {
    private boolean vegan;

    public Person(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegan() {
        return vegan;
    }
}

// Demo class με main
public class Main {
    public static void main(String[] args) {
        Wedding wedding = new Wedding("Athens");
        wedding.addPerson(new Person(false));
        wedding.addPerson(new Person(true));
        wedding.addPerson(new Person(true));
        wedding.addPerson(new Person(false));

        CostCalculator foodCalc = new FoodCostCalculator();
        CostCalculator photoCalc = new PhotoCostCalculator();

        System.out.println("Food cost: " + wedding.calculateCost(foodCalc));
        System.out.println("Photo cost: " + wedding.calculateCost(photoCalc));
    }
}
