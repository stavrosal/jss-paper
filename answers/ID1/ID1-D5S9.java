import java.util.ArrayList;
import java.util.List;

public class Wedding {
    private String venue;
    private List<Person> people;
    private CostCalculator cateringCalculator;
    private CostCalculator photographyCalculator;

    public Wedding(String venue, CostCalculator catering, CostCalculator photography) {
        this.venue = venue;
        this.people = new ArrayList<>();
        this.cateringCalculator = catering;
        this.photographyCalculator = photography;
    }

    public void addPerson(Person p) {
        this.people.add(p);
    }

    public double getCateringCost() {
        return cateringCalculator.calculateCost(people);
    }

    public double getPhotographyCost() {
        return photographyCalculator.calculateCost(people);
    }

    public double getTotalCost() {
        return getCateringCost() + getPhotographyCost();
    }
}


public class CateringCostCalculator implements CostCalculator {
    @Override
    public double calculateCost(List<Person> people) {
        int vegans = 0;
        for (Person p : people) {
            if (p.isVegan()) {
                vegans++;
            }
        }
        int nonVegans = people.size() - vegans;

        if (people.size() <= 500) {
            return nonVegans * 3 + vegans * 3.5;
        } else {
            return nonVegans * 2 + vegans * 2.5;
        }
    }
}


public interface CostCalculator {
    double calculateCost(List<Person> people);
}

public class Person {
    private boolean vegan;

    public Person(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegan() {
        return vegan;
    }
}

