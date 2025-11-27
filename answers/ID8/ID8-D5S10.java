import java.util.ArrayList;
import java.util.List;

public interface Service {
    double getCost(Wedding wedding);
    String getDescription();
}

public class FoodService implements Service {
    private static final double BASIC_MEAL_COST = 3.0;
    private static final double VEGAN_MEAL_COST = 3.5;
    private static final double DISCOUNT_BASIC_MEAL_COST = 2.0;
    private static final double DISCOUNT_VEGAN_MEAL_COST = 2.5;

    private static final int FOOD_DISCOUNT_THRESHOLD = 500;

    private int numPeople;
    private double ratePerPerson;

    public FoodService(int numPeople, double ratePerPerson) {
        this.numPeople = numPeople;
        this.ratePerPerson = ratePerPerson;
    }

    @Override
    public double getCost(Wedding wedding) {
        List<Person> people = wedding.getPeople();
        long veganCount = people.stream().filter(Person::isVegan).count();
        long nonVeganCount = numPeople - veganCount;

        if (numPeople > FOOD_DISCOUNT_THRESHOLD) {
            return nonVeganCount * DISCOUNT_BASIC_MEAL_COST + veganCount * DISCOUNT_VEGAN_MEAL_COST;
        } else {
            return nonVeganCount * BASIC_MEAL_COST + veganCount * VEGAN_MEAL_COST;
        }
    }

    @Override
    public String getDescription() {
        return "Food for " + people + " people";
    }
}

public class PhotographyService implements Service {
    private static final double PHOTO_COST_PER_PERSON = 1.0;
    private static final double DISCOUNT_PHOTO_COST_PER_PERSON = 0.75;
    private static final int PHOTO_DISCOUNT_THRESHOLD = 600;

    private int numPeople;
    private double ratePerPerson;

    public PhotographyService(int numPeople, double ratePerPerson) {
        this.numPeople = numPeople;
        this.ratePerPerson = ratePerPerson;
    }

    @Override
    public double getCost(Wedding wedding) {
        double rate = numPeople > PHOTO_DISCOUNT_THRESHOLD ? DISCOUNT_PHOTO_COST_PER_PERSON : PHOTO_COST_PER_PERSON;
        return numPeople * rate;
    }

    @Override
    public String getDescription() {
        return "Photography for " + people + " people";
    }
}

public class Wedding {
    private String venue;
    private List<Person> people;
    private List<Service> services;

    // Constructor
    public Wedding(String venue) {
        this.venue = venue;
        this.people = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    // Add a person
    public void addPerson(Person p) {
        this.people.add(p);
    }

    public void addService(Service s) {
        this.services.add(s);
    }

    // Calculate the total cost
    public double calculateTotalCost() {
        double total = 0.0;
        for (Service s : services) {
            total += s.getCost(this);
        }
        return total;
    }

    // Getters
    public String getVenue() {
        return venue;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people); // defensive copy
    }

    // Optional: Setter for venue if venue can change
    public void setVenue(String venue) {
        this.venue = venue;
    }
}