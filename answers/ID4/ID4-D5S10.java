import java.util.ArrayList;
import java.util.List;

abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract double getMealCost(boolean isDiscounted);
}

class Vegan extends Person {
    public Vegan(String name) {
        super(name);
    }

    @Override
    public double getMealCost(boolean isDiscounted) {
        return isDiscounted ? 2.5 : 3.5;
    }
}

class NonVegan extends Person {
    public NonVegan(String name) {
        super(name);
    }

    @Override
    public double getMealCost(boolean isDiscounted) {
        return isDiscounted ? 2.0 : 3.0;
    }
}

class Wedding {
    private static final int DISCOUNT_THRESHOLD = 500;
    private static final int PHOTO_DISCOUNT_THRESHOLD = 600;

    private String venue;
    private List<Person> people;

    public Wedding(String venue) {
        this.venue = venue;
        this.people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public double calculateFoodCost() {
        boolean discount = people.size() > DISCOUNT_THRESHOLD;
        double total = 0;
        for (Person p : people) {
            total += p.getMealCost(discount);
        }
        return total;
    }

    public double calculatePhotoCost() {
        int count = people.size();
        if (count > PHOTO_DISCOUNT_THRESHOLD) {
            return count * 0.75;
        } else {
            return count * 1.0;
        }
    }

    public String getVenue() {
        return venue;
    }

    public List<Person> getPeople() {
        return people;
    }
}